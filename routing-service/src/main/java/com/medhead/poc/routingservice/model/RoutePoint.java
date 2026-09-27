package com.medhead.poc.routingservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoutePoint {

    private Double latitude;
    private Double longitude;

}