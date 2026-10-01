package com.medhead.poc.recommendationservice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RecommendationGeneratedEventListener {

    @EventListener
    public void handle(
            RecommendationGeneratedEvent event) {

        System.out.println(
                "EVENT RecommendationGenerated : "
                        + event);
    }
}