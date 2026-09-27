package com.medhead.poc.routingservice.service.impl;

import com.graphhopper.GraphHopper;
import com.medhead.poc.routingservice.model.RoutePoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class RoutingServiceImplTest {

    @Test
    void shouldCreateService() {

        GraphHopper graphHopper = mock(GraphHopper.class);

        RoutingServiceImpl service = new RoutingServiceImpl(graphHopper);

        assertNotNull(service);
    }

    @Test
    void shouldCreateStartPoint() {

        RoutePoint start = RoutePoint.builder()
                .latitude(47.218371)
                .longitude(-1.553621)
                .build();

        assertNotNull(start);
        assertEquals(47.218371, start.getLatitude());
        assertEquals(-1.553621, start.getLongitude());
    }

    @Test
    void shouldCreateEndPoint() {

        RoutePoint end = RoutePoint.builder()
                .latitude(48.856614)
                .longitude(2.3522219)
                .build();

        assertNotNull(end);
        assertEquals(48.856614, end.getLatitude());
        assertEquals(2.3522219, end.getLongitude());
    }
}