package com.medhead.poc.recommendationservice.controller;

import com.medhead.poc.recommendationservice.dto.RecommendationRequestDto;
import com.medhead.poc.recommendationservice.dto.RecommendationResponseDto;
import com.medhead.poc.recommendationservice.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public List<RecommendationResponseDto> getRecommendations() {
        return recommendationService.getRecommendations();
    }

    @GetMapping("/{id}")
    public RecommendationResponseDto getRecommendation(
            @PathVariable Long id) {
        return recommendationService.getRecommendation(id);
    }

    @PostMapping
    public RecommendationResponseDto recommend(
            @RequestBody RecommendationRequestDto requestDto) {
        return recommendationService.recommend(requestDto);
    }
}