package com.adidas.service.route.impl;

import com.adidas.dao.route.RouteRepository;
import com.adidas.model.route.RouteEntity;
import com.adidas.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteRepository routeRepository;

	@Override
	public RouteEntity saveRoute(RouteEntity route) {
		return routeRepository.save(route);
	}

	@Override
	public List<RouteEntity> getAllRoutes() {
		return routeRepository.findAll();
	}

	@Override
	public void deleteRoute(long id) {
	    if(routeRepository.findById(id).isPresent()) {
	        routeRepository.deleteById(id);
	    }		
	}
}
