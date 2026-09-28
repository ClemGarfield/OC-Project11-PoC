package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class HospitalDto {

    private Long id;

    private String name;

    private Double latitude;

    private Double longitude;

    private Set<HospitalSpecialtyDto> specialties;
}