package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HospitalSpecialtyDto {

    private Long id;

    private SpecialtyDto specialty;

    private Integer availableBeds;
}