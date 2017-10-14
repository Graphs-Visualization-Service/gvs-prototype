package normalBindingTest;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VertexModel implements Observer{
  private final StringProperty label;
  private final DoubleProperty x;
  private final DoubleProperty y;

  public VertexModel(Vertex v) {
    this.label = new SimpleStringProperty(v.getLabel());
    this.x = new SimpleDoubleProperty(v.getX());
    this.y = new SimpleDoubleProperty(v.getY());
    v.addObserver(this);
  }

  public String getLabel() {
    return label.get();
  }

  public double getX() {
    return x.get();
  }

  public double getY() {
    return y.get();
  }

  public void setLabel(String s) {
    label.set(s);
  }

  public void setX(double d) {
    x.set(d);
  }

  public void setY(double d) {
    y.set(d);
  }

  public StringProperty labelProperty() {
    return label;
  }

  public DoubleProperty xProperty() {
    return x;
  }

  public DoubleProperty yProperty() {
    return y;
  }

  @Override
  public void update(Observable o, Object arg) {
    Vertex v = (Vertex)o;
    this.label.set(v.getLabel());
    this.x.set(v.getX());
    this.y.set(v.getY());
  }

}
