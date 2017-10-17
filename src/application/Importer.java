package application;

import application.model.Edge;
import application.model.Graph;
import application.model.Pair;
import application.model.Vertex;

public class Importer {

  private static Graph<Vertex, Edge> graph = new Graph<>();

  public static final Graph<Vertex, Edge> importGraph() {

    Vertex vertex1 = new Vertex();
    vertex1.setX(20);
    vertex1.setY(20);
    graph.addVertex(vertex1);

    Vertex vertex2 = new Vertex();
    vertex2.setX(60);
    vertex2.setY(60);
    graph.addVertex(vertex2);

    Vertex vertex3 = new Vertex();
    vertex3.setX(120);
    vertex3.setY(50);
    graph.addVertex(vertex3);

    Vertex vertex4 = new Vertex();
    vertex4.setX(240);
    vertex4.setY(340);
    graph.addVertex(vertex4);

    Pair<Vertex> pair1 = new Pair<Vertex>(vertex1, vertex2);
    Pair<Vertex> pair2 = new Pair<Vertex>(vertex1, vertex3);
    Pair<Vertex> pair3 = new Pair<Vertex>(vertex3, vertex4);
    Pair<Vertex> pair4 = new Pair<Vertex>(vertex2, vertex4);

    graph.addEdge(new Edge(pair1));
    graph.addEdge(new Edge(pair2));
    graph.addEdge(new Edge(pair3));
    graph.addEdge(new Edge(pair4));

    return graph;
  }
  
  public static final void updateGraph() {
    graph.getVertices().forEach(v -> {
      v.setX(v.getX() * 5);
      v.setY(v.getY() * 5);
    });
  }

}
