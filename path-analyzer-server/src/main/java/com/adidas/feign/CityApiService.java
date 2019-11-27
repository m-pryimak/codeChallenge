package com.adidas.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.adidas.model.Route;

@FeignClient(value = "city-data-server", fallback = CityApiFallbackService.class)
public interface CityApiService {
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes();
}
