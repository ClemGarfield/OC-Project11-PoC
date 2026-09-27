package com.medhead.poc.hospitalservice.controller;


import com.medhead.poc.hospitalservice.dto.SpecialtyDto;
import com.medhead.poc.hospitalservice.service.SpecialtyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SpecialtyController.class)
class SpecialtyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private SpecialtyService specialtyService;

    @Test
    void shouldReturnAllSpecialties() throws Exception {

        SpecialtyDto specialty = SpecialtyDto.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        when(specialtyService.getAllSpecialties())
                .thenReturn(List.of(specialty));

        mockMvc.perform(get("/specialties"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(21))
                .andExpect(jsonPath("$[0].name")
                        .value("Cardiology"));
    }

    @Test
    void shouldReturnOneSpecialty() throws Exception {

        SpecialtyDto specialty = SpecialtyDto.builder()
                .id(21L)
                .name("Cardiology")
                .specialtyGroup("General medicine group")
                .build();

        when(specialtyService.getSpecialty(21L))
                .thenReturn(specialty);

        mockMvc.perform(get("/specialties/21"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(21))
                .andExpect(jsonPath("$.name")
                        .value("Cardiology"));
    }
}