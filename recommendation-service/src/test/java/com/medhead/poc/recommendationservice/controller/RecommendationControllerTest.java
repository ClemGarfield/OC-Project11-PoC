package com.medhead.poc.recommendationservice.controller;

import com.medhead.poc.recommendationservice.dto.RecommendationResponseDto;
import com.medhead.poc.recommendationservice.service.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecommendationController.class)
class RecommendationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecommendationService recommendationService;

    @Test
    void shouldReturnRecommendations() throws Exception {

        when(recommendationService.getRecommendations())
                .thenReturn(List.of());

        mockMvc.perform(get("/recommendations"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnRecommendation() throws Exception {

        when(recommendationService.getRecommendation(1L))
                .thenReturn(null);

        mockMvc.perform(get("/recommendations/1"))
                .andExpect(status().isOk());
    }
}