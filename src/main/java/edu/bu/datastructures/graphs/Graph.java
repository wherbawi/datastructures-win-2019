package edu.bu.datastructures.graphs;

import java.util.List;

public interface Graph {
	public void addEdge(int source, int destination, boolean biDirectional);

	public void addNode(int nodeId, double lat, double lon);

	public void addEdge(int source, int destination, int cost, boolean biDirectional);

	public void addEdge(int source, int destination, int cost, int distance, boolean biDirectional);

	public List<Edge> getEdges(int node);

	public int getNumberOfEdges();

	double getLat(int nodeId);

	double getLon(int nodeId);

	int getNumberOfNodes();
}
