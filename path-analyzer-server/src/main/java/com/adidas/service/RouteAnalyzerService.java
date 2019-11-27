package com.adidas.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.engine.BFSAlgorithm;
import com.adidas.engine.DijkstraAlgorithm;
import com.adidas.feign.CityApiService;
import com.adidas.model.CityNode;
import com.adidas.model.Edge;
import com.adidas.model.Route;

@Service
public class RouteAnalyzerService{
	@Autowired
	private CityApiService routeService;
	@Autowired
	private DijkstraAlgorithm dijkstraAlgorithm;
	@Autowired
	private BFSAlgorithm bfsAlgorithm;

	public List<Route> getAllRoutes() {
		return routeService.getAllRoutes().getBody();
	}
	
	private List<Edge> generateEdges(){
		List<Edge> edges = new ArrayList<>();
		List<Route> routes = getAllRoutes();
		routes.forEach(r -> edges.add(createEdge(r)));
		return edges;
	}

	private Edge createEdge(Route route) {
		long duration = Duration.between(route.getDepartureTime(), route.getArrivalTime()).toMinutes();
		return  new Edge(route.getCity(), route.getDestinationCity(), duration);
	}
	
	public List<String> getShortPathByTime(String city, String destinationCity){
		dijkstraAlgorithm.setEdges(generateEdges());
		dijkstraAlgorithm.execute(city);
		return dijkstraAlgorithm.getPath(destinationCity);
	}
	
	public List<String> getShortPathByConnection(String city, String destinationCity){
		return bfsAlgorithm.execute(city, destinationCity, generateGraph());
	}
	
	private CityNode newCityNode(Map<String, CityNode> graph, String name, String... cities) {
		CityNode cityNode = graph.computeIfAbsent(name, k -> new CityNode(name));
		for (String cityName : cities) {
			CityNode city = newCityNode(graph, cityName);
			cityNode.addCity(city);
		}
		return cityNode;
	}

	private Map<String, CityNode> generateGraph() {
		Map<String, CityNode> graph = new HashMap<>();
		List<Route> routes = getAllRoutes();
		routes.forEach(r -> newCityNode(graph, r.getCity(), r.getDestinationCity()));
		return graph;
	}
}
