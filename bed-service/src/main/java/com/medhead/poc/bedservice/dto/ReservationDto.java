package com.medhead.poc.bedservice.dto;

import com.medhead.poc.bedservice.model.ReservationStatus;
import lombok.*;

import java.time.LocalDateTime;

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