package com.medhead.poc.bedservice.controller;

import com.medhead.poc.bedservice.dto.BedDto;
import com.medhead.poc.bedservice.service.BedService;
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

@WebMvcTest(BedController.class)
class BedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BedService bedService;

    @Test
    void shouldReturnBeds() throws Exception {

        BedDto bed = BedDto.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        when(bedService.getAllBeds())
                .thenReturn(List.of(bed));

        mockMvc.perform(get("/beds"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void shouldReturnAvailableBeds() throws Exception {

        BedDto bed = BedDto.builder()
                .id(1L)
                .hospitalId(1L)
                .specialtyId(21L)
                .available(true)
                .build();

        when(bedService.getAvailableBeds())
                .thenReturn(List.of(bed));

        mockMvc.perform(get("/beds/available"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].available").value(true));
    }
}