package application.view;

import application.controller.AppViewModel;
import application.model.Vertex;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AppView {

  private final AppViewModel viewModel = new AppViewModel();

  @FXML
  private Canvas graphCanvas;

  @FXML
  public void importFile() {
    viewModel.importGraph();
    drawGraph();
  }

  public void drawGraph() {
    GraphicsContext gc = graphCanvas.getGraphicsContext2D();

    viewModel.getVertices().forEach(v -> {
      gc.setFill(Color.GREEN);
      gc.fillOval(v.get().getX(), v.get().getY(), v.get().getSize(),
          v.get().getSize());
    });
    viewModel.getEdges().forEach(e -> {

      Vertex first = e.get().getVertexPair().getFirst();
      Vertex second = e.get().getVertexPair().getSecond();

      gc.strokeLine(first.getX() + first.getSize() / 2,
          first.getY() + first.getSize() / 2,
          second.getX() + second.getSize() / 2,
          second.getY() + second.getSize() / 2);
    });

    graphCanvas.setOnMouseDragged(e -> {
      double mouseX = e.getX();
      double mouseY = e.getY();
      
      ObjectProperty<Vertex> draggedVertex = viewModel.findVertex(mouseX, mouseY);
      if (draggedVertex != null) {
        draggedVertex.get().setX(mouseX);
        draggedVertex.get().setY(mouseY);
      }
    });
  }

}
