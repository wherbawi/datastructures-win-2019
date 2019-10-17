package edu.bu.datastructures.xmlreader;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.bu.datastructures.graphs.Graph;

public class XmlReader {

	public static void main(String[] args) throws Exception {

		String pathname = "C:\\teaching\\BU\\data structures\\project//test.osm";
		Graph graph = createGraph(pathname);
		/*
		 * System.out.println("edges of node 15"); List<Edge> edges =
		 * graph.getEdges(15); for (Edge edge : edges) { System.out.println(edge); }
		 * System.out.println("edges of node 500"); edges = graph.getEdges(500); for
		 * (Edge edge : edges) { System.out.println(edge); }
		 * 
		 * System.out.println("number of nodes " + nList.getLength());
		 * System.out.println("number of edges " + graph.getNumberOfEdges());
		 */ 
	}

	public static Graph createGraph(String pathname) throws ParserConfigurationException, SAXException, IOException {
		File xmlFile = new File(pathname);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		NodeList nList = doc.getElementsByTagName("node");
		int length = nList.getLength();
		for (int i = 0; i < length; i++) {
			Element elementNode = (Element) nList.item(i);
			System.out.println("node id " + elementNode.getAttribute("id") + " at lat,lon"
					+ elementNode.getAttribute("lat") + "," + elementNode.getAttribute("lon"));

		}

		NodeList ways = doc.getElementsByTagName("way");
		for (int i = 0; i < ways.getLength(); i++) {
			Element elementWay = (Element) ways.item(i);
			// double speedMS = getSpeedKMH(elementWay) * 1000 / 3600.0;
			NodeList wayNodes = elementWay.getElementsByTagName("nd");
			// System.out.println("new way");
			for (int j = 1; j < wayNodes.getLength(); j++) {
				Element prevWayNodeElement = (Element) wayNodes.item(j - 1);
				Element wayNodeElement = (Element) wayNodes.item(j);
				 System.out.println("way node " + wayNodeElement.getAttribute("ref"));
			}

			NodeList tags = elementWay.getElementsByTagName("tag");
			for (int j = 0; j < tags.getLength(); j++) {
				Element wayTagItem = (Element) tags.item(j);
				if (wayTagItem.getAttribute("k").equals("highway")) {
					 System.out.println(wayTagItem.getAttribute("v"));
				}
			}
		}
		return null;
	}

}
