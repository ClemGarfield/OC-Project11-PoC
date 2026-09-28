package com.medhead.poc.bedservice.controller;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(
            ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<ReservationResponseDto> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservations/{id}")
    public ReservationResponseDto getReservation(
            @PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/reservations")
    public ReservationResponseDto createReservation(
            @RequestBody ReservationRequestDto reservationRequestDto) {
        return reservationService.createReservation(
                reservationRequestDto);
    }

    @DeleteMapping("/reservations/{id}")
    public void cancelReservation(
            @PathVariable Long id) {
        reservationService.cancelReservation(id);
    }
}