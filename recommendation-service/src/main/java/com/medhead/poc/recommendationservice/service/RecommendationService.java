package com.medhead.poc.recommendationservice.service;

import com.medhead.poc.recommendationservice.dto.RecommendationRequestDto;
import com.medhead.poc.recommendationservice.dto.RecommendationResponseDto;

import java.util.List;

public interface RecommendationService {

    RecommendationResponseDto recommend(
            RecommendationRequestDto requestDto);

    RecommendationResponseDto getRecommendation(
            Long id);

    List<RecommendationResponseDto> getRecommendations();
}