package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoutePointDto
{
    private Double latitude;
    private Double longitude;
}