package com.medhead.poc.hospitalservice.event;

public record HospitalCapacityUpdatedEvent(
        Long hospitalId,
        Long specialtyId,
        Integer availableBeds
) {
}