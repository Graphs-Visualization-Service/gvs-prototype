package application.view;

import application.Importer;
import application.controller.GraphViewModel;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class GraphView {

  private final GraphViewModel viewModel = new GraphViewModel();

  @FXML
  private Group graphArea;

  @FXML
  public void importFile() {
    viewModel.importGraph();
    drawGraph();
  }

  public void drawGraph() {

    viewModel.getVertices().forEach(v -> {

      Circle circle = new Circle();
      circle.setRadius(20);
      circle.centerXProperty().bindBidirectional(v.getXProperty());
      circle.centerYProperty().bindBidirectional(v.getYProperty());

      circle.setOnMouseDragged(e -> {
        circle.setCenterX(e.getSceneX());
        circle.setCenterY(e.getSceneY());
        e.consume();
      });

      graphArea.getChildren().add(circle);
    });
  }
  
  public void updatePositions() {
    Importer.updateGraph();
  }

}
