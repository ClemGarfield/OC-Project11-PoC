package com.medhead.poc.recommendationservice.dto;

public record RecommendationRequestDto(

        Double patientLatitude,
        Double patientLongitude,
        Long specialtyId

) {
}