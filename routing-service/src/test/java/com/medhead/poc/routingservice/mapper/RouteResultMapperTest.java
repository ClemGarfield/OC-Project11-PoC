package com.medhead.poc.routingservice.mapper;

import com.medhead.poc.routingservice.dto.RouteResultDto;
import com.medhead.poc.routingservice.model.RoutePoint;
import com.medhead.poc.routingservice.model.RouteResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class RouteResultMapperTest {

    @Test
    void shouldMapModelToDto() {

        RouteResult routeResult = RouteResult.builder()
                .distance(1250.5)
                .travelTime(180000)
                .points(List.of(
                        RoutePoint.builder()
                                .latitude(47.21)
                                .longitude(-1.55)
                                .build(),
                        RoutePoint.builder()
                                .latitude(47.22)
                                .longitude(-1.54)
                                .build()
                ))
                .build();

        RouteResultDto dto = RouteResultMapper.toDto(routeResult);

        assertNotNull(dto);
        assertEquals(routeResult.getDistance(), dto.getDistance());
        assertEquals(routeResult.getTravelTime(), dto.getTravelTime());
        assertEquals(2, dto.getPoints().size());
    }

    @Test
    void shouldMapDtoToModel() {

        RouteResultDto dto = RouteResultDto.builder()
                .distance(1250.5)
                .travelTime(180000)
                .points(List.of())
                .build();

        RouteResult model = RouteResultMapper.toModel(dto);

        assertNotNull(model);
        assertEquals(dto.getDistance(), model.getDistance());
        assertEquals(dto.getTravelTime(), model.getTravelTime());
    }

    @Test
    void shouldReturnNullDtoWhenModelIsNull() {
        assertNull(RouteResultMapper.toDto(null));
    }

    @Test
    void shouldReturnNullModelWhenDtoIsNull() {
        assertNull(RouteResultMapper.toModel(null));
    }
}