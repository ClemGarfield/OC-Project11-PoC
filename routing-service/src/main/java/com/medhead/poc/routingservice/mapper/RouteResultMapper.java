package com.medhead.poc.routingservice.mapper;

import com.medhead.poc.routingservice.dto.RouteResultDto;
import com.medhead.poc.routingservice.model.RouteResult;

public final class RouteResultMapper {

    private RouteResultMapper() {
    }

    public static RouteResultDto toDto(RouteResult model) {
        if (model == null) {
            return null;
        }

        return RouteResultDto.builder()
                .distance(model.getDistance())
                .travelTime(model.getTravelTime())
                .points(RoutePointMapper.toDtoList(model.getPoints()))
                .build();
    }

    public static RouteResult toModel(RouteResultDto dto) {
        if (dto == null) {
            return null;
        }

        return RouteResult.builder()
                .distance(dto.getDistance())
                .travelTime(dto.getTravelTime())
                .points(RoutePointMapper.toModelList(dto.getPoints()))
                .build();
    }
}