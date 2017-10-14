package application.model;

import java.util.ArrayList;
import java.util.Collection;

public class Graph<V extends Vertex, E extends Edge> {

  private final Collection<V> vertices;
  private final Collection<E> edges;

  public Graph() {
    vertices = new ArrayList<>();
    edges = new ArrayList<>();
  }

  public final Collection<E> getEdges() {
    return edges;
  }

  public final Collection<V> getVertices() {
    return vertices;
  }

  public final boolean addVertex(V vertex) {
    return vertices.add(vertex);
  }

  public final boolean removeVertex(V vertex) {
    return vertices.remove(vertex);
  }

  public final boolean addEdge(E edge) {
    return edges.add(edge);
  }

  public final boolean removeEdge(E edge) {
    return edges.remove(edge);
  }

}
