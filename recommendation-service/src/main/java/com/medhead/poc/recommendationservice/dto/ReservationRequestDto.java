package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;

@Builder
public record ReservationRequestDto(
        Long bedId,
        Double patientLatitude,
        Double patientLongitude
) {
}