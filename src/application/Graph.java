package application;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Graph {

	private final Set<Edge> edges;
	private final Map<Shape, Node> nodes;

	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
	
	public void addNode(Circle shape) {
		if (!nodes.containsKey(shape)) {
			Node newNode = new Node(shape);
			nodes.put(shape, newNode); 
		}
	}

	public void addBidirectionalEdge(Circle start, Circle end, Shape edgeShape) {
		Node startNode = nodes.get(start);
		Node endNode = nodes.get(end);
		if (startNode != null && endNode != null) {
			Edge edge = new Edge(startNode, endNode, edgeShape);
			startNode.addEdge(edge);
			endNode.addEdge(edge);
			edges.add(edge);
		}
	}
	
	public Set<Edge> getEdges() {
		return this.edges;
	}
	
	public Map<Shape, Node> getNodes() {
		return this.nodes;
	}
}
