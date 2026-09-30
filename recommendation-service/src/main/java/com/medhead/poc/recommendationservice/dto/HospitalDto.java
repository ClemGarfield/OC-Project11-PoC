package com.medhead.poc.recommendationservice.dto;

import lombok.*;


import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {

    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Set<HospitalSpecialtyDto> specialties;
}