package application;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class Node {

	private Shape shape;
	private final Set<Edge> edges;

	public Node(Circle shape) {
		edges = new HashSet<>();
		this.shape = shape;
		addStyle();
		addDragSupport();
	}
	
	private void addStyle() {
		this.shape.setFill(Color.CORAL);
		this.shape.setStroke(Color.BLACK);
		this.shape.setStrokeWidth(2);
	}
	
	private void addDragSupport() {
		shape.setOnMouseDragged(e -> {
			Circle node = (Circle) e.getSource();
			node.setCenterX(e.getSceneX());
			node.setCenterY(e.getSceneY());
			
			getEdges().forEach(edge -> {
				Line line = (Line) edge.getShape();
				if (edge.getStartNode() == this) {
					line.setStartX(e.getSceneX());
					line.setStartY(e.getSceneY());
				} else {
					line.setEndX(e.getSceneX());
					line.setEndY(e.getSceneY());
				}
			});
			
			e.consume();
		});
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public Shape getShape() {
		return shape;
	}
}
