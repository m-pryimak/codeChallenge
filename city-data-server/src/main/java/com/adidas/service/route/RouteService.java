package com.adidas.service.route;

import java.util.List;

import com.adidas.model.route.RouteEntity;

public interface RouteService {
	public RouteEntity saveRoute(RouteEntity route);
	public List<RouteEntity> getAllRoutes();
	public void deleteRoute(long id);
}
