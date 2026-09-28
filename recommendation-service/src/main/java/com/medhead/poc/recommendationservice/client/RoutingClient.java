package com.medhead.poc.recommendationservice.client;

import com.medhead.poc.recommendationservice.dto.RouteResultDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RoutingClient {

    private final RestClient restClient;

    public RoutingClient(
            @Value("${services.routing.base-url}")
            String baseUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public RouteResultDto calculateRoute(
            Double fromLatitude,
            Double fromLongitude,
            Double toLatitude,
            Double toLongitude) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/routing/route")
                        .queryParam("fromLatitude", fromLatitude)
                        .queryParam("fromLongitude", fromLongitude)
                        .queryParam("toLatitude", toLatitude)
                        .queryParam("toLongitude", toLongitude)
                        .build())
                .retrieve()
                .body(RouteResultDto.class);
    }
}