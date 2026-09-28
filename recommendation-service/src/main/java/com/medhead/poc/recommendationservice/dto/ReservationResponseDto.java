package com.medhead.poc.recommendationservice.dto;

import com.medhead.poc.recommendationservice.model.ReservationStatus;
import lombok.Builder;

@Builder
public record ReservationResponseDto(
        Long id,
        ReservationStatus status
) {
}