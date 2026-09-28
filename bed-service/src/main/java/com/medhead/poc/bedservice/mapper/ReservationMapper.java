package com.medhead.poc.bedservice.mapper;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.model.Reservation;

public final class ReservationMapper {

    private ReservationMapper() {
    }

    public static Reservation fromRequestDto(
            ReservationRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Reservation.builder()
                .bedId(dto.bedId())
                .patientLatitude(dto.patientLatitude())
                .patientLongitude(dto.patientLongitude())
                .build();
    }

    public static ReservationResponseDto toResponseDto(
            Reservation reservation) {

        if (reservation == null) {
            return null;
        }

        return ReservationResponseDto.builder()
                .id(reservation.getId())
                .status(reservation.getStatus())
                .build();
    }
}