package application.controller;

import java.util.Observable;
import java.util.Observer;

import application.model.Vertex;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;

/**
 * @author Michi
 */
public class VertexViewModel implements Observer {

  private final Vertex vertex;

  private final DoubleProperty xProperty = new SimpleDoubleProperty();
  private final DoubleProperty yProperty = new SimpleDoubleProperty();

  /**
   * 
   * @param relatedVertex
   */
  public VertexViewModel(Vertex relatedVertex) {
    this.vertex = relatedVertex;
    vertex.addObserver(this);

    xProperty.addListener(this::xProperyListener);
  }

  /**
   * Creates the binding from the business logic {@link Vertex} to the
   * presentation {@link VertexViewModel} properties.
   * 
   * As soon as any {@link Vertex} field is updated, the corresponding property
   * will be notified.
   * 
   * @param o
   *          updated {@link Vertex} object
   * @param arg
   *          additional arguments
   */
  @Override
  public void update(Observable o, Object arg) {
    Vertex vertex = (Vertex) o;
    this.xProperty.set(vertex.getX());
    this.yProperty.set(vertex.getY());
  }

  /**
   * Informs the business logic <code>Vertex</code> about changes, made in the
   * UI. (e.g. drag vertex)
   * 
   * @param observable
   * @param oldValue
   *          value before the change
   * @param newValue
   *          value after the change
   */
  private final void xProperyListener(
      ObservableValue<? extends Number> observable, Number oldValue,
      Number newValue) {
    double newX = (double) newValue;
    vertex.setX(newX);
  }

  public DoubleProperty getXProperty() {
    return xProperty;
  }

  public DoubleProperty getYProperty() {
    return yProperty;
  }

}
