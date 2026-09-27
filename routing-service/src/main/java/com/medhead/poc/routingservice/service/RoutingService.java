package com.medhead.poc.routingservice.service;

import com.medhead.poc.routingservice.model.RoutePoint;
import com.medhead.poc.routingservice.model.RouteResult;

public interface RoutingService {

    RouteResult calculateRoute(
            RoutePoint startPoint,
            RoutePoint endPoint
    );

}
