package com.medhead.poc.routingservice.mapper;

import com.medhead.poc.routingservice.dto.RoutePointDto;
import com.medhead.poc.routingservice.model.RoutePoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoutePointMapperTest {

    @Test
    void shouldMapModelToDto() {

        RoutePoint routePoint = RoutePoint.builder()
                .latitude(47.218371)
                .longitude(-1.553621)
                .build();

        RoutePointDto dto = RoutePointMapper.toDto(routePoint);

        assertNotNull(dto);
        assertEquals(routePoint.getLatitude(), dto.getLatitude());
        assertEquals(routePoint.getLongitude(), dto.getLongitude());
    }

    @Test
    void shouldMapDtoToModel() {

        RoutePointDto dto = RoutePointDto.builder()
                .latitude(47.218371)
                .longitude(-1.553621)
                .build();

        RoutePoint model = RoutePointMapper.toModel(dto);

        assertNotNull(model);
        assertEquals(dto.getLatitude(), model.getLatitude());
        assertEquals(dto.getLongitude(), model.getLongitude());
    }

    @Test
    void shouldReturnNullDtoWhenModelIsNull() {
        assertNull(RoutePointMapper.toDto(null));
    }

    @Test
    void shouldReturnNullModelWhenDtoIsNull() {
        assertNull(RoutePointMapper.toModel(null));
    }
}