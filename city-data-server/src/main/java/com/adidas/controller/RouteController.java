package com.adidas.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.model.route.RouteEntity;
import com.adidas.service.route.RouteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/routes")
public class RouteController {
	@Autowired
	private RouteService routeService;

	@ApiOperation(
			consumes = "application/json",
			produces = "application/json",
			value = "Save route data in database.")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successful save the route data"),
		    @ApiResponse(code = 403, message = "Forbidden request. User has no authorization"),
		    @ApiResponse(code = 500, message = "Internal server error...")}
	)
	@PostMapping
	public ResponseEntity<RouteEntity> saveRoute(@RequestBody @NotNull RouteEntity route) {
		return new ResponseEntity<>(routeService.saveRoute(route), HttpStatus.OK);
	}

	@ApiOperation(
			consumes = "application/json",
			produces = "application/json",
			value = "Returns all the routes data present in database.")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successful retrieval of the route data"),
		    @ApiResponse(code = 403, message = "Forbidden request. User has no authorization"),
		    @ApiResponse(code = 500, message = "Internal server error...")}
	)
	@GetMapping
	public ResponseEntity<List<RouteEntity>> getAllRoutes() {
		return new ResponseEntity<>(routeService.getAllRoutes(), HttpStatus.OK);
	}
}
