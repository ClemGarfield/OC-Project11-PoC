package com.medhead.poc.routingservice.model;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RouteResult {
    private double distance;
    private long travelTime;
    private List<RoutePoint> points;
}