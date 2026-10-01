package com.medhead.poc.recommendationservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recommendation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hospitalId;

    private Long specialtyId;

    private Double patientLatitude;

    private Double patientLongitude;

    private Double distanceKm;

    private Long reservationId;

    @Enumerated(EnumType.STRING)
    private RecommendationStatus status;

    private String reservationStatus;
}