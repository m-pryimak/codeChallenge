package com.adidas.feign;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.adidas.model.Route;
@Component
public class CityApiFallbackService implements CityApiService{

	@Override
	public ResponseEntity<List<Route>> getAllRoutes() {
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

}
