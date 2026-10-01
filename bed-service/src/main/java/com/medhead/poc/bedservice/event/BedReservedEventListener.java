package com.medhead.poc.bedservice.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BedReservedEventListener {

    @EventListener
    public void handle(
            BedReservedEvent event) {

        System.out.println(
                "EVENT BedReserved : "
                        + event);
    }
}