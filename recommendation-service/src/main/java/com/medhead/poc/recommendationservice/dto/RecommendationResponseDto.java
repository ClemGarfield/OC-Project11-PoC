package com.medhead.poc.recommendationservice.dto;

public record RecommendationResponseDto(

        Long hospitalId,
        String hospitalName,
        Long specialtyId,
        Double distanceKm,
        Integer availableBeds

) {
}