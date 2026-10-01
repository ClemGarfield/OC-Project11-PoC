package com.medhead.poc.bedservice.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class BedReservedEventPublisher {

    private final ApplicationEventPublisher publisher;

    public BedReservedEventPublisher(
            ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(
            BedReservedEvent event) {

        publisher.publishEvent(event);
    }
}