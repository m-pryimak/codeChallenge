package com.adidas.model;

import java.time.LocalDateTime;

public class Route {
	private String city;
	private String destinationCity;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;	

	public Route() {
	}

	public Route(String city, String destinationCity, LocalDateTime departureTime, LocalDateTime arrivalTime) {
		super();
		this.city = city;
		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
