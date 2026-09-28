package com.medhead.poc.bedservice.dto;

import com.medhead.poc.bedservice.model.ReservationStatus;
import lombok.Builder;

@Builder
public record ReservationResponseDto(
        Long id,
        ReservationStatus status
) {
}