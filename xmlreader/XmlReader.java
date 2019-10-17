package edu.bu.datastructures.xmlreader;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.geotools.referencing.GeodeticCalculator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.bu.datastructures.graphs.AdjacencyListGraph;
import edu.bu.datastructures.graphs.Edge;
import edu.bu.datastructures.graphs.Graph;
import edu.bu.datastructures.list.ArrayBasedList;

public class XmlReader {

	public static void main(String[] args) throws Exception {

		String pathname = "C:\\teaching\\BU\\data structures\\project//Bethlehem-Jerusalem.xml";
		Graph graph = createGraph(pathname);
		/*
		 * System.out.println("edges of node 15"); List<Edge> edges =
		 * graph.getEdges(15); for (Edge edge : edges) { System.out.println(edge); }
		 * System.out.println("edges of node 500"); edges = graph.getEdges(500); for
		 * (Edge edge : edges) { System.out.println(edge); }
		 * 
		 * System.out.println("number of nodes " + nList.getLength());
		 * System.out.println("number of edges " + graph.getNumberOfEdges());
		 */ graph.getEdges(5);
	}

	public static Graph createGraph(String pathname) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(pathname);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		NodeList nList = doc.getElementsByTagName("node");
		GeodeticCalculator calculator = new GeodeticCalculator();
		Graph graph = new AdjacencyListGraph(nList.getLength());

		Hashtable<String, Integer> osmId2nodeId = new Hashtable<>();
		int length = nList.getLength();
		double[][] nodesCoord = new double[length][2];
		for (int i = 0; i < length; i++) {
			Element elementNode = (Element) nList.item(i);

			// System.out.println("node id " + elementNode.getAttribute("id") + " at lat,lon
			// "
			// + elementNode.getAttribute("lat") + "," + elementNode.getAttribute("lon"));
			osmId2nodeId.put(elementNode.getAttribute("id"), i);
			nodesCoord[i][0] = Double.parseDouble(elementNode.getAttribute("lat"));
			nodesCoord[i][0] = Double.parseDouble(elementNode.getAttribute("lon"));
			graph.addNode(i, Double.parseDouble(elementNode.getAttribute("lat")),
					Double.parseDouble(elementNode.getAttribute("lon")));
			// if (i % 10000 == 0)
			// System.out.println(i);
		}

		NodeList ways = doc.getElementsByTagName("way");
		for (int i = 0; i < ways.getLength(); i++) {
			Element elementWay = (Element) ways.item(i);
			double speedMS = getSpeedKMH(elementWay) * 1000 / 3600.0;
			NodeList wayNodes = elementWay.getElementsByTagName("nd");
			// System.out.println("new way");
			for (int j = 1; j < wayNodes.getLength(); j++) {
				Element prevWayNodeElement = (Element) wayNodes.item(j - 1);
				Element wayNodeElement = (Element) wayNodes.item(j);
				// System.out.println("way node " + wayNodeElement.getAttribute("ref"));
				Integer source = osmId2nodeId.get(wayNodeElement.getAttribute("ref"));
				Integer destination = osmId2nodeId.get(prevWayNodeElement.getAttribute("ref"));
				int orthodromicDist = getOrthodromicDist(nodesCoord[source][0], nodesCoord[source][1],
						nodesCoord[destination][0], nodesCoord[destination][1]);
				int timeInSec = (int) (orthodromicDist / speedMS);
				graph.addEdge(source, destination, timeInSec, orthodromicDist, true);

			}

			NodeList tags = elementWay.getElementsByTagName("tag");
			for (int j = 0; j < tags.getLength(); j++) {
				Element wayTagItem = (Element) tags.item(j);
				if (wayTagItem.getAttribute("k").equals("highway")) {
					// System.out.println(wayTagItem.getAttribute("v"));
				}
			}
		}
		return graph;
	}

	private static int getSpeedKMH(Element elementWay) {
		NodeList tags = elementWay.getElementsByTagName("tag");
		for (int j = 0; j < tags.getLength(); j++) {
			Element wayTagItem = (Element) tags.item(j);
			if (wayTagItem.getAttribute("k").equals("highway")) {
				switch (wayTagItem.getAttribute("v").toLowerCase().trim()) {
				case "motorway":
					return 120;
				case "primary":
					return 80;
				case "secondary":
					return 50;
				case "tertiary ":
					return 40;
				case "residential":
					return 20;
				default:
					return 30;
				}
			}
		}
		return 30;
	}

	private static int getOrthodromicDist(double srcLat, double srcLon, double dstLat, double dstLon) {
		GeodeticCalculator calculator = new GeodeticCalculator();
		calculator.setStartingGeographicPoint(srcLon, srcLat);
		calculator.setDestinationGeographicPoint(dstLon, dstLat);
		return (int) calculator.getOrthodromicDistance();
	}

}
