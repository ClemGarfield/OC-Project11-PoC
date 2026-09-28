package com.medhead.poc.recommendationservice.dto;

import lombok.*;
import java.time.LocalDateTime;
import com.medhead.poc.recommendationservice.model.ReservationStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long id;

    private Long bedId;

    private Double patientLatitude;

    private Double patientLongitude;

    private ReservationStatus status;

    private LocalDateTime createdAt;
}