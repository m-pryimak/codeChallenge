package com.adidas.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adidas.model.Edge;

@Component
@Scope("prototype")
public class DijkstraAlgorithm {

    private List<Edge> edges;
    private Set<String> settledNodes;
    private Set<String> unSettledNodes;
    private Map<String, String> predecessors;
    private Map<String, Long> distance;

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public void execute(String source) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0L);
        unSettledNodes.add(source);
        while (!unSettledNodes.isEmpty()) {
            String node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(String node) {
        List<String> adjacentNodes = getNeighbors(node);
        for (String target : adjacentNodes) {
            long calculatedDistance = getShortestDistance(node) + getDistance(node, target);
            if (getShortestDistance(target) > calculatedDistance) {
                distance.put(target, calculatedDistance);
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private long getDistance(String node, String target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Could not get distance for current cities");
    }

    private List<String> getNeighbors(String node) {
        List<String> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private String getMinimum(Set<String> vertexes) {
        String minimum = null;
        for (String vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(String value) {
        return settledNodes.contains(value);
    }

    private Long getShortestDistance(String destination) {
        Long d = distance.get(destination);
        return d == null ? Long.MAX_VALUE : d;
    }

    public List<String> getPath(String target) {
        List<String> path = new LinkedList<>();
        String step = target;
        if (predecessors.get(step) == null) {
            return path;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
