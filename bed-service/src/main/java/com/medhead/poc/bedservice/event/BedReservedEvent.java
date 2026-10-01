package com.medhead.poc.bedservice.event;

public record BedReservedEvent(
        Long reservationId,
        Long bedId
) {
}