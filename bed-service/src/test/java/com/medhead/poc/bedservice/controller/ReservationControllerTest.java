package com.medhead.poc.bedservice.controller;

import com.medhead.poc.bedservice.dto.ReservationResponseDto;
import com.medhead.poc.bedservice.model.ReservationStatus;
import com.medhead.poc.bedservice.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ReservationService reservationService;

    @Test
    void shouldReturnReservations() throws Exception {

        ReservationResponseDto reservation =
                new ReservationResponseDto(
                        1L,
                        ReservationStatus.CONFIRMED);

        when(reservationService.getAllReservations())
                .thenReturn(List.of(reservation));

        mockMvc.perform(get("/reservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void shouldReturnReservation() throws Exception {

        ReservationResponseDto reservation =
                new ReservationResponseDto(
                        1L,
                        ReservationStatus.CONFIRMED);

        when(reservationService.getReservation(1L))
                .thenReturn(reservation);

        mockMvc.perform(get("/reservations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
}