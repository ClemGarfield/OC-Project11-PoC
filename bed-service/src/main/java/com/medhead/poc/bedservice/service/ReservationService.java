package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {

    List<ReservationResponseDto> getAllReservations();

    ReservationResponseDto getReservation(Long id);

    ReservationResponseDto createReservation(
            ReservationRequestDto reservationRequestDto);

    void cancelReservation(Long id);
}