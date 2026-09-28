package com.medhead.poc.recommendationservice.mapper;

import com.medhead.poc.recommendationservice.dto.RecommendationRequestDto;
import com.medhead.poc.recommendationservice.dto.RecommendationResponseDto;
import com.medhead.poc.recommendationservice.model.Recommendation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecommendationMapperTest {

    @Test
    void shouldMapRequestDtoToRecommendation() {

        RecommendationRequestDto dto =
                new RecommendationRequestDto(
                        0.0,
                        47.2184,
                        21L);

        Recommendation recommendation =
                RecommendationMapper.fromRequestDto(dto);

        assertNotNull(recommendation);
    }

    @Test
    void shouldReturnNullWhenRequestDtoIsNull() {

        assertNull(
                RecommendationMapper.fromRequestDto(null));
    }

    @Test
    void shouldReturnNullWhenRecommendationIsNull() {

        assertNull(
                RecommendationMapper.toResponseDto(null));
    }
}