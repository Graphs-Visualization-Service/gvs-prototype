package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Edge {
	
	private final Node startNode;
    private final Node endNode;
    private final Shape shape;

    public Edge(Node startNode, Node endNode, Shape representation) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.shape = representation;
        addStyle();
    }
    
	private void addStyle() {
		this.shape.setStroke(Color.BLACK);
		this.shape.setStrokeWidth(2);
	}


    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public Shape getShape() {
        return shape;
    }
}
