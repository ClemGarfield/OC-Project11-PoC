package com.medhead.poc.recommendationservice.repository;

import com.medhead.poc.recommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository
        extends JpaRepository<Recommendation, Long> {
}