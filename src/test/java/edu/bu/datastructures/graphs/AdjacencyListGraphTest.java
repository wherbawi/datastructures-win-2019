package edu.bu.datastructures.graphs;

import org.junit.Test;

public class AdjacencyListGraphTest {
@Test
public void testAddEdge() {
	AdjacencyListGraph graph = new AdjacencyListGraph(5);
	graph.addEdge(0, 1, true);
	graph.addEdge(1, 2, true);
	System.out.println(graph.getNumberOfEdges());
	System.out.println(graph.getEdges(0).get(0).destination);
	
}
}
