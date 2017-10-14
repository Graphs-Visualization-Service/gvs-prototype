package beanAdapterTest;

public class Vertex {

  private double x;
  private double y;
  private String label;

  public Vertex() {
  }

  public Vertex(double x, double y, String label) {
    this.x = x;
    this.y = y;
    this.label = label;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
