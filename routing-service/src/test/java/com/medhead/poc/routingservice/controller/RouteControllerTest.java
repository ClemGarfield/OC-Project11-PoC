package com.medhead.poc.routingservice.controller;

import com.medhead.poc.routingservice.model.RouteResult;
import com.medhead.poc.routingservice.service.RoutingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RouteController.class)
class RouteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RoutingService routingService;

    @Test
    void shouldReturnRoute() throws Exception {

        when(routingService.calculateRoute(any(), any()))
                .thenReturn(
                        RouteResult.builder()
                                .distance(1000)
                                .travelTime(60000)
                                .points(List.of())
                                .build()
                );

        mockMvc.perform(
                        get("/api/routing/route")
                                .param("fromLatitude", "47.218")
                                .param("fromLongitude", "-1.553")
                                .param("toLatitude", "48.856")
                                .param("toLongitude", "2.352")
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance").value(1000))
                .andExpect(jsonPath("$.travelTime").value(60000));
    }
}