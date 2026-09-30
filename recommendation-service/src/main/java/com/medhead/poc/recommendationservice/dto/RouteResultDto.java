package com.medhead.poc.recommendationservice.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteResultDto {

    private double distance;
    private long travelTime;

    private List<RoutePointDto> points;

}