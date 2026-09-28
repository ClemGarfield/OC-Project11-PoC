package com.medhead.poc.bedservice.dto;

import lombok.Builder;

@Builder
public record ReservationRequestDto(
        Long bedId,
        Double patientLatitude,
        Double patientLongitude
) {
}