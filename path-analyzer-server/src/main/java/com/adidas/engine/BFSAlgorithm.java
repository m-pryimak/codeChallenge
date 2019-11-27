package com.adidas.engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adidas.model.CityNode;

@Component
@Scope("prototype")
public class BFSAlgorithm {
	public List<String> execute(String start, String end, Map<String, CityNode> graph) {
		List<String> bfsList = new LinkedList<>();
		Queue<CityNode> queue = new LinkedList<>();
		Map<String, CityNode> prev = new HashMap<>();
		CityNode current = graph.get(start);

		queue.add(current);
		current.setVisited(true);

		while (!queue.isEmpty()) {

			current = queue.remove();

			if (current.getCity().equals(end)) {
				break;
			} else {
				List<CityNode> currentCities = current.getCities();
				for (CityNode currentCity : currentCities) {
					if (!currentCity.isVisited()) {
						queue.add(currentCity);
						currentCity.setVisited(true);
						prev.put(currentCity.getCity(), current);
					}
				}
			}
		}

		if (!current.getCity().equals(end)) {
			return Collections.emptyList();
		}
		for (CityNode node = graph.get(end); node != null; node = prev.get(node.getCity())) {
			bfsList.add(node.getCity());
		}
		Collections.reverse(bfsList);

		return bfsList;
	}
}
