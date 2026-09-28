package com.medhead.poc.bedservice.service;

import com.medhead.poc.bedservice.dto.ReservationRequestDto;
import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.model.Reservation;
import com.medhead.poc.bedservice.model.ReservationStatus;
import com.medhead.poc.bedservice.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceImplTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    void shouldReturnAllReservations() {

        Reservation reservation = Reservation.builder()
                .id(1L)
                .bedId(1L)
                .status(ReservationStatus.CONFIRMED)
                .createdAt(LocalDateTime.now())
                .build();

        when(reservationRepository.findAll())
                .thenReturn(List.of(reservation));

        List<ReservationResponseDto> result =
                reservationService.getAllReservations();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.getFirst().id());
    }

    @Test
    void shouldCreateReservation() {

        ReservationRequestDto dto =
                ReservationRequestDto.builder()
                        .bedId(1L)
                        .patientLatitude(51.5074)
                        .patientLongitude(-0.1278)
                        .build();

        Reservation saved = Reservation.builder()
                .id(1L)
                .bedId(1L)
                .status(ReservationStatus.CONFIRMED)
                .createdAt(LocalDateTime.now())
                .build();

        when(reservationRepository.save(any()))
                .thenReturn(saved);

        ReservationResponseDto result =
                reservationService.createReservation(dto);

        assertNotNull(result);
        assertEquals(1L, result.id());
        assertEquals(
                ReservationStatus.CONFIRMED,
                result.status());
    }

    @Test
    void shouldCancelReservation() {

        Reservation reservation = Reservation.builder()
                .id(1L)
                .status(ReservationStatus.CONFIRMED)
                .build();

        when(reservationRepository.findById(1L))
                .thenReturn(java.util.Optional.of(reservation));

        reservationService.cancelReservation(1L);

        ArgumentCaptor<Reservation> captor =
                ArgumentCaptor.forClass(Reservation.class);

        verify(reservationRepository)
                .save(captor.capture());

        assertEquals(
                ReservationStatus.CANCELLED,
                captor.getValue().getStatus());
    }
}