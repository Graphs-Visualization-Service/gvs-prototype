package application.model;

public class Edge {

  private final Pair<Vertex> vertexPair;
  private final EdgeType edgeType;

  public Edge(Pair<Vertex> vertexPair) {
    this.vertexPair = vertexPair;
    this.edgeType = EdgeType.UNDIRECTED;
  }

  public Edge(Pair<Vertex> vertexPair, EdgeType edgeType) {
    this.vertexPair = vertexPair;
    this.edgeType = edgeType;
  }

  public final EdgeType getEdgeType() {
    return edgeType;
  }

  public Pair<Vertex> getVertexPair() {
    return vertexPair;
  }
}
