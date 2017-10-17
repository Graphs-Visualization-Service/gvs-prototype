package application.model;

import java.util.Observable;

public class Vertex extends Observable {

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
    System.out.println("New x value" + x);
    this.x = x;
    setChanged();
    notifyObservers();
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    System.out.println("New y value" + y);
    this.y = y;
    setChanged();
    notifyObservers();
  }
}
