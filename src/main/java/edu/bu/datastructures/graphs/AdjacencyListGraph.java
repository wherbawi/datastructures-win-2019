package edu.bu.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListGraph implements Graph {
	List<Edge>[] nodes;
	double[][] nodesCoords;
	int numberOfEdges = 0;

	public AdjacencyListGraph(int numberOfNodes) {
		nodes = new List[numberOfNodes];
		nodesCoords = new double[numberOfNodes][2];
	}

	public void addEdge(int source, int destination, boolean biDirectional) {
		if (nodes[source] == null)
			nodes[source] = new ArrayList<>();
		nodes[source].add(new Edge(destination));
		numberOfEdges++;
		if (biDirectional) {
			if (nodes[destination] == null)
				nodes[destination] = new ArrayList<>();
			nodes[destination].add(new Edge(source));
			numberOfEdges++;
		}
	}

	public void addEdge(int source, int destination, int cost, boolean biDirectional) {
		if (nodes[source] == null)
			nodes[source] = new ArrayList<>();
		nodes[source].add(new Edge(destination, cost, 0));
		if (biDirectional) {
			if (nodes[destination] == null)
				nodes[destination] = new ArrayList<>();
			nodes[destination].add(new Edge(source, cost, 0));
		}
	}

	public List<Edge> getEdges(int node) {
		return nodes[node] == null ? Collections.emptyList() : nodes[node];

	}

	@Override
	public int getNumberOfNodes() {
		return nodes.length;
	}

	@Override
	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	@Override
	public void addEdge(int source, int destination, int cost, int distance, boolean biDirectional) {
		if (nodes[source] == null)
			nodes[source] = new ArrayList<>();
		nodes[source].add(new Edge(destination, cost, distance));
		if (biDirectional) {
			if (nodes[destination] == null)
				nodes[destination] = new ArrayList<>();
			nodes[destination].add(new Edge(source, cost, distance));
		}
	}

	@Override
	public void addNode(int nodeId, double lat, double lon) {
		nodesCoords[nodeId][0] = lat;
		nodesCoords[nodeId][1] = lon;
	}

	@Override
	public double getLat(int nodeId) {
		return nodesCoords[nodeId][0];

	}

	@Override
	public double getLon(int nodeId) {
		// TODO Auto-generated method stub
		return nodesCoords[nodeId][1];
	}
}
