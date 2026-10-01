package com.medhead.poc.routingservice.controller;

import com.medhead.poc.routingservice.dto.RouteResultDto;
import com.medhead.poc.routingservice.mapper.RouteResultMapper;
import com.medhead.poc.routingservice.model.RoutePoint;
import com.medhead.poc.routingservice.model.RouteResult;
import com.medhead.poc.routingservice.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routing")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RouteController {

    private final RoutingService routingService;

    @GetMapping("/route")
    public RouteResultDto calculateRoute(
            @RequestParam Double fromLatitude,
            @RequestParam Double fromLongitude,
            @RequestParam Double toLatitude,
            @RequestParam Double toLongitude) {

        RouteResult routeResult = routingService.calculateRoute(
                RoutePoint.builder()
                        .latitude(fromLatitude)
                        .longitude(fromLongitude)
                        .build(),
                RoutePoint.builder()
                        .latitude(toLatitude)
                        .longitude(toLongitude)
                        .build()
        );

        return RouteResultMapper.toDto(routeResult);
    }
}