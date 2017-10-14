package application.model;

import java.util.Collection;
import java.util.Iterator;

public final class Pair<T> {

  private T first;
  private T second;

  public Pair(T value1, T value2) {
    if (value1 == null || value2 == null) {
      throw new IllegalArgumentException("Pair cannot contain null values");
    }
    setFirst(value1);
    setSecond(value2);
  }

  public Pair(Collection<? extends T> values) {
    if (values == null) {
      throw new IllegalArgumentException("Input collection cannot be null");
    }
    if (values.size() == 2) {
      if (values.contains(null)) {
        throw new IllegalArgumentException("Pair cannot contain null values");
      }
      Iterator<? extends T> iter = values.iterator();
      first = iter.next();
      second = iter.next();
    } else {
      throw new IllegalArgumentException(
          "Pair may only be created from a Collection of exactly 2 elements");
    }
  }

  public T getSecond() {
    return second;
  }

  public void setSecond(T second) {
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public void setFirst(T first) {
    this.first = first;
  }

}
