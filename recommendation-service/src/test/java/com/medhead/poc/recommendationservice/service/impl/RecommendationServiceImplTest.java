package com.medhead.poc.recommendationservice.service.impl;

import com.medhead.poc.recommendationservice.client.BedClient;
import com.medhead.poc.recommendationservice.client.HospitalClient;
import com.medhead.poc.recommendationservice.client.RoutingClient;
import com.medhead.poc.recommendationservice.dto.*;
import com.medhead.poc.recommendationservice.model.Recommendation;
import com.medhead.poc.recommendationservice.repository.RecommendationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceImplTest {

    @Mock
    private RecommendationRepository repository;

    @Mock
    private HospitalClient hospitalClient;

    @Mock
    private BedClient bedClient;

    @Mock
    private RoutingClient routingClient;

    @InjectMocks
    private RecommendationServiceImpl service;

    @Test
    void shouldReturnRecommendations() {

        when(repository.findAll())
                .thenReturn(List.of(
                        Recommendation.builder()
                                .id(1L)
                                .build()));

        List<RecommendationResponseDto> result =
                service.getRecommendations();

        assertNotNull(result);
    }

    @Test
    void shouldReturnRecommendation() {

        when(repository.findById(1L))
                .thenReturn(Optional.of(
                        Recommendation.builder()
                                .id(1L)
                                .hospitalId(1L)
                                .specialtyId(1L)
                                .distanceKm(10.0)
                                .build()));

        RecommendationResponseDto result =
                service.getRecommendation(1L);

        assertNotNull(result);
    }

    @Test
    void shouldRecommendHospital() {

        RecommendationRequestDto request =
                new RecommendationRequestDto(
                        47.2184,
                        -1.5536,
                        1L);

        HospitalDto hospital =
                HospitalDto.builder()
                        .id(1L)
                        .name("Hospital")
                        .latitude(47.2000)
                        .longitude(-1.5400)
                        .specialties(Set.of())
                        .build();

        BedDto bed =
                BedDto.builder()
                        .id(1L)
                        .hospitalId(1L)
                        .specialtyId(1L)
                        .available(true)
                        .build();

        RouteResultDto route =
                RouteResultDto.builder()
                        .distance(10.0)
                        .travelTime(600)
                        .build();

        when(hospitalClient.getHospitalsBySpecialty(1L))
                .thenReturn(List.of(hospital));

        when(bedClient.getAvailableBedsBySpecialty(1L))
                .thenReturn(List.of(bed));

        when(routingClient.calculateRoute(
                any(),
                any(),
                any(),
                any()))
                .thenReturn(route);

        when(repository.save(any()))
                .thenReturn(
                        Recommendation.builder()
                                .id(1L)
                                .hospitalId(1L)
                                .specialtyId(1L)
                                .distanceKm(10.0)
                                .build());

        RecommendationResponseDto result =
                service.recommend(request);

        assertNotNull(result);
    }
}