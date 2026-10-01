package com.medhead.poc.hospitalservice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HospitalCapacityUpdatedEventListener {

    @EventListener
    public void handle(
            HospitalCapacityUpdatedEvent event) {

        System.out.println(
                "EVENT HospitalCapacityUpdated : "
                        + event);
    }
}