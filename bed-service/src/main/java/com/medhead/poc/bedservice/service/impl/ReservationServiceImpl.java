package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.event.BedReservedEvent;
import com.medhead.poc.bedservice.event.BedReservedEventPublisher;
import com.medhead.poc.bedservice.mapper.ReservationMapper;
import com.medhead.poc.bedservice.model.Reservation;
import com.medhead.poc.bedservice.model.ReservationStatus;
import com.medhead.poc.bedservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl
        implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final BedReservedEventPublisher
            bedReservedEventPublisher;

    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            BedReservedEventPublisher bedReservedEventPublisher) {

        this.reservationRepository =
                reservationRepository;

        this.bedReservedEventPublisher =
                bedReservedEventPublisher;
    }

    @Override
    public List<ReservationResponseDto> getAllReservations() {

        return reservationRepository.findAll()
                .stream()
                .map(ReservationMapper::toResponseDto)
                .toList();
    }

    @Override
    public ReservationResponseDto getReservation(
            Long id) {

        return reservationRepository.findById(id)
                .map(ReservationMapper::toResponseDto)
                .orElse(null);
    }

    @Override
    public ReservationResponseDto createReservation(
            ReservationRequestDto reservationRequestDto) {

        Reservation reservation =
                ReservationMapper.fromRequestDto(
                        reservationRequestDto);

        reservation.setStatus(
                ReservationStatus.CONFIRMED);

        reservation.setCreatedAt(
                LocalDateTime.now());

        Reservation saved =
                reservationRepository.save(
                        reservation);

        bedReservedEventPublisher.publish(
                new BedReservedEvent(
                        saved.getId(),
                        reservationRequestDto.bedId()
                )
        );

        System.out.println(
                "EVENT BedReserved : "
                        + new BedReservedEvent(
                        saved.getId(),
                        reservationRequestDto.bedId()
                )
        );

        return ReservationMapper.toResponseDto(
                saved);
    }

    @Override
    public void cancelReservation(
            Long id) {

        reservationRepository.findById(id)
                .ifPresent(reservation -> {

                    reservation.setStatus(
                            ReservationStatus.CANCELLED);

                    reservationRepository.save(
                            reservation);
                });
    }
}