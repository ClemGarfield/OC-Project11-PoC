package com.medhead.poc.recommendationservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialtyDto {

    private Long id;

    private String name;

    private String specialtyGroup;
}