package com.medhead.poc.recommendationservice.mapper;

import com.medhead.poc.recommendationservice.dto.RecommendationRequestDto;
import com.medhead.poc.recommendationservice.dto.RecommendationResponseDto;
import com.medhead.poc.recommendationservice.model.Recommendation;

public final class RecommendationMapper {

    private RecommendationMapper() {
    }

    public static Recommendation fromRequestDto(
            RecommendationRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Recommendation.builder()
                .specialtyId(dto.specialtyId())
                .patientLatitude(dto.patientLatitude())
                .patientLongitude(dto.patientLongitude())
                .build();
    }

    public static RecommendationResponseDto toResponseDto(
            Recommendation recommendation) {

        if (recommendation == null) {
            return null;
        }

        return new RecommendationResponseDto(
                recommendation.getHospitalId(),
                null,
                recommendation.getSpecialtyId(),
                recommendation.getDistanceKm(),
                null,
                recommendation.getReservationId(),
                recommendation.getReservationStatus()
        );
    }
}