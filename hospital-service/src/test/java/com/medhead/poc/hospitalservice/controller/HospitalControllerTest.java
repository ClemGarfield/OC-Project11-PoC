package com.medhead.poc.hospitalservice.controller;

import com.medhead.poc.hospitalservice.dto.HospitalDto;
import com.medhead.poc.hospitalservice.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class)
class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HospitalService hospitalService;

    @Test
    void shouldReturnHospitalsBySpecialty() throws Exception {

        HospitalDto hospital = HospitalDto.builder()
                .id(1L)
                .name("Fred Brooks Hospital")
                .latitude(51.5074)
                .longitude(-0.1278)
                .specialties(Set.of())
                .build();

        given(hospitalService.getHospitalsBySpecialty(21L))
                .willReturn(List.of(hospital));

        mockMvc.perform(
                        get("/hospitals")
                                .param("specialtyId", "21"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Fred Brooks Hospital"));
    }

    @Test
    void shouldReturnBadRequestWhenSpecialtyIdMissing() throws Exception {

        mockMvc.perform(get("/hospitals"))
                .andExpect(status().isBadRequest());
    }
}