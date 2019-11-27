package com.adidas.model;

public class Edge {
	private final String source;
	private final String destination;
	private final long weight;

	public Edge(String source, String destination, long weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String getDestination() {
		return destination;
	}

	public String getSource() {
		return source;
	}

	public long getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}
}
