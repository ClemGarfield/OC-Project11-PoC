package com.medhead.poc.routingservice.service.impl;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.util.PointList;
import com.medhead.poc.routingservice.model.RoutePoint;
import com.medhead.poc.routingservice.model.RouteResult;
import com.medhead.poc.routingservice.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutingServiceImpl implements RoutingService {

    private final GraphHopper graphHopper;

    @Override
    public RouteResult calculateRoute(
            RoutePoint startPoint,
            RoutePoint endPoint
    ) {

        GHRequest request = new GHRequest(
                startPoint.getLatitude(),
                startPoint.getLongitude(),
                endPoint.getLatitude(),
                endPoint.getLongitude()
        ).setProfile("car");

        GHResponse response = graphHopper.route(request);

        if (response.hasErrors()) {
            throw new IllegalStateException(
                    response.getErrors().toString()
            );
        }

        ResponsePath path = response.getBest();

        PointList pointList = path.getPoints();

        List<RoutePoint> points = new ArrayList<>();

        for (int i = 0; i < pointList.size(); i++) {
            points.add(
                    RoutePoint.builder()
                            .latitude(pointList.getLat(i))
                            .longitude(pointList.getLon(i))
                            .build()
            );
        }

        return RouteResult.builder()
                .distance(path.getDistance())
                .travelTime(path.getTime())
                .points(points)
                .build();
    }
}