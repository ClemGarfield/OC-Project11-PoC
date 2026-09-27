package com.medhead.poc.routingservice.mapper;

import com.medhead.poc.routingservice.dto.RoutePointDto;
import com.medhead.poc.routingservice.model.RoutePoint;

import java.util.List;

public final class RoutePointMapper {

    private RoutePointMapper() {
    }

    public static RoutePointDto toDto(RoutePoint model) {
        if (model == null) {
            return null;
        }

        return RoutePointDto.builder()
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .build();
    }

    public static RoutePoint toModel(RoutePointDto dto) {
        if (dto == null) {
            return null;
        }

        return RoutePoint.builder()
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .build();
    }

    public static List<RoutePointDto> toDtoList(List<RoutePoint> models) {
        return models.stream()
                .map(RoutePointMapper::toDto)
                .toList();
    }

    public static List<RoutePoint> toModelList(List<RoutePointDto> dtos) {
        return dtos.stream()
                .map(RoutePointMapper::toModel)
                .toList();
    }
}