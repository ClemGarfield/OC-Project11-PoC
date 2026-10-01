package com.medhead.poc.recommendationservice.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RecommendationGeneratedEventPublisher {

    private final ApplicationEventPublisher publisher;

    public RecommendationGeneratedEventPublisher(
            ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(
            RecommendationGeneratedEvent event) {

        publisher.publishEvent(event);
    }
}