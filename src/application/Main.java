package application;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		// Main frame
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// Button for test data
		Button btnAddNode = new Button("Setup test graph");
		btnAddNode.setOnAction(event -> {
			printTestGraph(root);
		});
		root.setTop(btnAddNode);
		
		// Show main frame
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void printTestGraph(BorderPane root) {
		Graph graph = setupTestGraph();
		graph.getEdges().forEach(e -> {
			root.getChildren().add(e.getShape());
		});
		graph.getNodes().forEach((s, n) -> {
			root.getChildren().add(s);
		});
	}

	private Graph setupTestGraph() {
		Graph graph = new Graph();
		addTestNodes(graph);
		addTestEdges(graph);

		return graph;
	}

	private Graph addTestNodes(Graph graph) {
		for (int i = 0; i < 5; i++) {
			Circle node = new Circle(100, 100 + 50 * i, 20);
			graph.addNode(node);
		}
		return graph;
	}

	private Graph addTestEdges(Graph graph) {
		List<Shape> nodes = graph.getNodes().keySet().stream().collect(Collectors.toList());
		for (int i = 1; i < nodes.size(); i++) {
			// link all nodes with the first node (for test purpose)
			Circle source = (Circle) nodes.get(i);
			Circle target = (Circle) nodes.get(0);

			Line line = new Line(source.getCenterX(), source.getCenterY(), target.getCenterX(), target.getCenterY());
			graph.addBidirectionalEdge(source, target, line);
		}
		return graph;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
