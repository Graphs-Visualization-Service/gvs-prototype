package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.Importer;
import application.model.Edge;
import application.model.Graph;
import application.model.Vertex;

public class GraphViewModel {

  private List<VertexViewModel> vertices = new ArrayList<>();

  /**
   * Sets the current {@link Graph} which needs to be visualized.
   * 
   * @param graph
   *          current {@link Graph}
   */
  public void setGraph(Graph<Vertex, Edge> graph) {
    graph.getVertices().forEach(v -> {
      VertexViewModel vertexViewModel = new VertexViewModel(v);
      vertexViewModel.getXProperty().set(v.getX());
      vertexViewModel.getYProperty().set(v.getY());
      vertices.add(vertexViewModel);
    });
  }

  public List<VertexViewModel> getVertices() {
    return this.vertices;
  }

  public void importGraph() {
    Graph<Vertex, Edge> graph = Importer.importGraph();
    setGraph(graph);
  }
}
