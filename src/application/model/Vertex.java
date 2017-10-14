package application.model;

public class Vertex {

  private double x;
  private double y;
  
  public final int getSize() {
    return 20;
  }
  
  public final double getInDegree() {
    return 1;
  }

  public final double getOutDegree() {
    return 2;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    System.out.println(x);
    this.x = x;
  }

  public double getY() {
    System.out.println(x);
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
}
