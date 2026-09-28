package com.medhead.poc.recommendationservice.client;

import com.medhead.poc.recommendationservice.dto.BedDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class BedClient {

    private final RestClient restClient;

    public BedClient(
            @Value("${services.bed.base-url}")
            String baseUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<BedDto> getBeds() {

        return restClient.get()
                .uri("/beds")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public BedDto getBed(
            Long bedId) {

        return restClient.get()
                .uri("/beds/{id}", bedId)
                .retrieve()
                .body(BedDto.class);
    }

    public List<BedDto> getAvailableBeds() {

        return restClient.get()
                .uri("/beds/available")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public List<BedDto> getAvailableBedsBySpecialty(
            Long specialtyId) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/beds/search")
                        .queryParam("specialtyId", specialtyId)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
