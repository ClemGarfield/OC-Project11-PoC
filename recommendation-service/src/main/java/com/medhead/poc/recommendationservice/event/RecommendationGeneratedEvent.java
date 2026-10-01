package com.medhead.poc.recommendationservice.event;

public record RecommendationGeneratedEvent(
        Long recommendationId,
        Long hospitalId,
        Long specialtyId,
        Double distance,
        Long reservationId
) {
}
