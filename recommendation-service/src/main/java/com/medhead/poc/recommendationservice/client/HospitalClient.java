package com.medhead.poc.recommendationservice.client;

import com.medhead.poc.recommendationservice.dto.HospitalDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class HospitalClient {

    private final RestClient restClient;

    public HospitalClient(
            @Value("${services.hospital.base-url}")
            String baseUrl) {

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<HospitalDto> getHospitalsBySpecialty(
            Long specialtyId) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hospitals")
                        .queryParam("specialtyId", specialtyId)
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}