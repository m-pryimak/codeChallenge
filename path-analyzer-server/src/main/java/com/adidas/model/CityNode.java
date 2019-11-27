package com.adidas.model;

import java.util.LinkedList;
import java.util.List;

public class CityNode {
	private final String city;
	private final List<CityNode> cities = new LinkedList<>();

	private boolean visited;

	public CityNode(String city) {
		this.city = city;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String getCity() {
		return city;
	}

	public List<CityNode> getCities() {
		return cities;
	}
	
    public void addCity(CityNode cityNode) {
        this.cities.add(cityNode);
    }
}
