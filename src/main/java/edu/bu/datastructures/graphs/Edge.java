package edu.bu.datastructures.graphs;

public class Edge {
	int destination;
	private int cost;
	private int distance;

	@Override
	public String toString() {
		return "Edge [destination=" + destination + ", cost=" + cost + ", distance=" + distance + "]";
	}

	public Edge(int destination) {
		this.destination = destination;
	}

	public Edge(int destination, int cost, int distance) {
		this.destination = destination;
		this.cost = cost;
		this.distance= distance;
	}

	public int getDestination() {
		return destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	

	
}
