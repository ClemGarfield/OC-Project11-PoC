package com.medhead.poc.recommendationservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RouteResultDto {

    private double distance;
    private long travelTime;

    private List<RoutePointDto> points;

}