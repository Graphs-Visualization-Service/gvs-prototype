package application.controller;

import application.Importer;
import application.model.Edge;
import application.model.Graph;
import application.model.Vertex;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AppViewModel {

  private final ObservableList<ObjectProperty<Vertex>> vertices = FXCollections
      .observableArrayList();
  private final ObservableList<ObjectProperty<Edge>> edges = FXCollections
      .observableArrayList();

  private Graph<Vertex, Edge> currentGraph;

  public final void redraw() {
    currentGraph.getVertices().forEach(vertex -> {
      ObjectProperty<Vertex> vertexProperty = new SimpleObjectProperty<Vertex>();
      vertexProperty.set(vertex);
      vertices.add(vertexProperty);
    });

    currentGraph.getEdges().forEach(edge -> {
      ObjectProperty<Edge> edgeProperty = new SimpleObjectProperty<Edge>();
      edgeProperty.set(edge);
      edges.add(edgeProperty);
    });
  }

  public final void importGraph() {
    this.currentGraph = Importer.importGraph();
    redraw();
  }

  public ObjectProperty<Vertex> findVertex(double x, double y) {
    for (ObjectProperty<Vertex> v : getVertices()) {
      if (isInArea(v.get(), x, y)) {
        return v;
      }
    }
    return null;
  }

  private boolean isInArea(Vertex vertex, double x, double y) {
    return vertex.getX() < x && vertex.getY() < y
        && vertex.getX() + vertex.getSize() > x
        && vertex.getY() + vertex.getSize() > y;
  }

  public ObservableList<ObjectProperty<Vertex>> getVertices() {
    return vertices;
  }

  public ObservableList<ObjectProperty<Edge>> getEdges() {
    return edges;
  }
}
