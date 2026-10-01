package com.medhead.poc.recommendationservice.client;

import com.medhead.poc.recommendationservice.dto.ReservationRequestDto;
import com.medhead.poc.recommendationservice.dto.ReservationResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ReservationClient {

    private final RestClient restClient;

    public ReservationClient(
            @Value("${bed-service.url:http://localhost:8086}")
            String bedServiceUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(bedServiceUrl)
                .build();
    }

    public ReservationResponseDto createReservation(
            ReservationRequestDto request) {

        return restClient.post()
                .uri("/reservations")
                .body(request)
                .retrieve()
                .body(ReservationResponseDto.class);
    }
}