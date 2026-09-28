package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialtyDto {

    private Long id;

    private String name;

    private String specialtyGroup;
}