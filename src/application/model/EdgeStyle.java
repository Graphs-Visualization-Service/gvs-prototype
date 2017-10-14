package application.model;

import application.model.enums.LineColor;
import application.model.enums.LineStyle;
import application.model.enums.LineThickness;

public class EdgeStyle {
  public final LineColor getLineColor() {
    return LineColor.DEFAULT;
  }

  public final LineStyle getLineStyle() {
    return LineStyle.DEFAULT;
  }

  public final LineThickness getLineThickness() {
    return LineThickness.DEFAULT;
  }
}
