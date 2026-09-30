package com.medhead.poc.recommendationservice.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutePointDto
{
    private Double latitude;
    private Double longitude;
}