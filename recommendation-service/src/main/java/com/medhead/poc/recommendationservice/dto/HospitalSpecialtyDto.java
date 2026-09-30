package com.medhead.poc.recommendationservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalSpecialtyDto {

    private Long id;

    private SpecialtyDto specialty;

    private Integer availableBeds;
}