package com.adidas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.service.RouteAnalyzerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/path/calculate")
@RestController
public class ShortestRouteController {
	@Autowired
	private RouteAnalyzerService analyserService;

	@ApiOperation(
			consumes = "application/json",
			produces = "application/json",
			value = "Returns the shortest routes between two cities")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successful retrieval of the shortest route"),
		    @ApiResponse(code = 403, message = "Forbidden request. User has no authorization"),
		    @ApiResponse(code = 500, message = "Internal server error...")}
	)
	@GetMapping("/bytime")
	public List<String> calculatePathByTime(@RequestParam String city, @RequestParam String destinationCity) {
		return analyserService.getShortPathByTime(city, destinationCity);
	}
	@ApiOperation(
			consumes = "application/json",
			produces = "application/json",
			value = "Returns the quickest route between two cities")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successful retrieval of the quickest route"),
		    @ApiResponse(code = 403, message = "Forbidden request. User has no authorization"),
		    @ApiResponse(code = 500, message = "Internal server error...")}
	)
	@GetMapping("/byconnection")
	public List<String> calculatePathByConnection(@RequestParam String city, @RequestParam String destinationCity) {
		return analyserService.getShortPathByConnection(city, destinationCity);
	}
}
