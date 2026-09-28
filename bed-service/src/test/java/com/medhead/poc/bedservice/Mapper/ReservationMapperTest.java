package com.medhead.poc.bedservice.mapper;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.model.Reservation;
import com.medhead.poc.bedservice.model.ReservationStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationMapperTest {

    @Test
    void shouldMapRequestDtoToModel() {

        ReservationRequestDto dto =
                ReservationRequestDto.builder()
                        .bedId(2L)
                        .patientLatitude(51.5074)
                        .patientLongitude(-0.1278)
                        .build();

        Reservation reservation =
                ReservationMapper.fromRequestDto(dto);

        assertNotNull(reservation);
        assertEquals(2L, reservation.getBedId());
        assertEquals(
                51.5074,
                reservation.getPatientLatitude());
        assertEquals(
                -0.1278,
                reservation.getPatientLongitude());
    }

    @Test
    void shouldMapModelToResponseDto() {

        Reservation reservation = Reservation.builder()
                .id(1L)
                .bedId(2L)
                .patientLatitude(51.5074)
                .patientLongitude(-0.1278)
                .status(ReservationStatus.CONFIRMED)
                .build();

        ReservationResponseDto dto =
                ReservationMapper.toResponseDto(
                        reservation);

        assertNotNull(dto);
        assertEquals(1L, dto.id());
        assertEquals(
                ReservationStatus.CONFIRMED,
                dto.status());
    }

    @Test
    void shouldReturnNullWhenRequestDtoIsNull() {

        assertNull(
                ReservationMapper.fromRequestDto(
                        null));
    }

    @Test
    void shouldReturnNullWhenModelIsNull() {

        assertNull(
                ReservationMapper.toResponseDto(
                        null));
    }
}