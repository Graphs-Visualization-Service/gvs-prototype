package normalBindingTest;

import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VertexModel implements Observer{
  private final StringProperty label= new SimpleStringProperty();
  private final DoubleProperty x=new SimpleDoubleProperty();
  private final DoubleProperty y= new SimpleDoubleProperty();
  
  private Vertex v;

  public VertexModel(Vertex v) {
    reloadFromModel();
    v.addObserver(this);
  }

  private void reloadFromModel() {
    this.label.setValue(v.getLabel());
    this.x.setValue(v.getX());
    this.y.setValue(v.getY());
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
    reloadFromModel();
  }

}
