package com.medhead.poc.recommendationservice.service.impl;

import com.medhead.poc.recommendationservice.client.BedClient;
import com.medhead.poc.recommendationservice.client.HospitalClient;
import com.medhead.poc.recommendationservice.client.ReservationClient;
import com.medhead.poc.recommendationservice.client.RoutingClient;
import com.medhead.poc.recommendationservice.dto.*;
import com.medhead.poc.recommendationservice.event.RecommendationGeneratedEvent;
import com.medhead.poc.recommendationservice.event.RecommendationGeneratedEventPublisher;
import com.medhead.poc.recommendationservice.mapper.RecommendationMapper;
import com.medhead.poc.recommendationservice.model.Recommendation;
import com.medhead.poc.recommendationservice.repository.RecommendationRepository;
import com.medhead.poc.recommendationservice.service.RecommendationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl
        implements RecommendationService {

    private final RecommendationRepository repository;
    private final HospitalClient hospitalClient;
    private final BedClient bedClient;
    private final RoutingClient routingClient;
    private final ReservationClient  reservationClient;
    private final RecommendationGeneratedEventPublisher recommendationGeneratedEventPublisher;

    public RecommendationServiceImpl(
            RecommendationRepository repository,
            HospitalClient hospitalClient,
            BedClient bedClient,
            RoutingClient routingClient,
            ReservationClient reservationClient,
            RecommendationGeneratedEventPublisher recommendationGeneratedEventPublisher) {

        this.repository = repository;
        this.hospitalClient = hospitalClient;
        this.bedClient = bedClient;
        this.routingClient = routingClient;
        this.reservationClient = reservationClient;
        this.recommendationGeneratedEventPublisher = recommendationGeneratedEventPublisher;
    }

    @Override
    public RecommendationResponseDto recommend(
            RecommendationRequestDto requestDto) {

        List<HospitalDto> hospitals =
                hospitalClient.getHospitalsBySpecialty(
                        requestDto.specialtyId());

        List<BedDto> availableBeds =
                bedClient.getAvailableBedsBySpecialty(
                        requestDto.specialtyId());

        if (hospitals.isEmpty() || availableBeds.isEmpty()) {
            return null;
        }

        HospitalDto hospital = hospitals.getFirst();
        BedDto bed = availableBeds.getFirst();

        ReservationResponseDto reservation =
                reservationClient.createReservation(
                        ReservationRequestDto.builder()
                                .bedId(bed.getId())
                                .patientLatitude(
                                        requestDto.patientLatitude())
                                .patientLongitude(
                                        requestDto.patientLongitude())
                                .build()
                );

        System.out.println(
                "RESERVATION ID = "
                        + reservation.id());
        System.out.println(
                "RESERVATION STATUS = "
                        + reservation.status());

        RouteResultDto route =
                routingClient.calculateRoute(
                        requestDto.patientLatitude(),
                        requestDto.patientLongitude(),
                        hospital.getLatitude(),
                        hospital.getLongitude());

        Recommendation recommendation =
                RecommendationMapper.fromRequestDto(
                        requestDto);

        Recommendation saved =
                repository.save(recommendation);

        recommendationGeneratedEventPublisher.publish(
                new RecommendationGeneratedEvent(
                        saved.getId(),
                        hospital.getId(),
                        requestDto.specialtyId(),
                        route.getDistance(),
                        reservation.id()
                )
        );

        return new RecommendationResponseDto(
                hospital.getId(),
                hospital.getName(),
                requestDto.specialtyId(),
                route.getDistance(),
                availableBeds.size() - 1,
                reservation.id(),
                reservation.status().name()
        );
    }

    @Override
    public RecommendationResponseDto getRecommendation(
            Long id) {

        return repository.findById(id)
                .map(RecommendationMapper::toResponseDto)
                .orElse(null);
    }

    @Override
    public List<RecommendationResponseDto> getRecommendations() {

        return repository.findAll()
                .stream()
                .map(RecommendationMapper::toResponseDto)
                .toList();
    }
}