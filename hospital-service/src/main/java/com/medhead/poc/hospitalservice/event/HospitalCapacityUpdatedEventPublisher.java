package com.medhead.poc.hospitalservice.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class HospitalCapacityUpdatedEventPublisher {

    private final ApplicationEventPublisher publisher;

    public HospitalCapacityUpdatedEventPublisher(
            ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(
            HospitalCapacityUpdatedEvent event) {

        publisher.publishEvent(event);
    }
}