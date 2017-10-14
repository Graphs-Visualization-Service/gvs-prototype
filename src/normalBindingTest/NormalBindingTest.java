package normalBindingTest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NormalBindingTest extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Main frame
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 400, 400);

    // Show main frame
    primaryStage.setScene(scene);
    primaryStage.show();

    AnchorPane middlePane = new AnchorPane();
    root.setCenter(middlePane);

    Circle c = new Circle(100, 100, 10);
    middlePane.getChildren().add(c);

    Vertex v = new Vertex(50, 50, "v1");
    VertexModel vm = new VertexModel(v);

    c.centerXProperty().bindBidirectional(vm.xProperty());

    Button btn = new Button("click");
    root.setBottom(btn);
    btn.setOnMouseClicked(event -> {
      v.setX(v.getX() + 10);
      System.out.println("v x: " + v.getX() + "vm x: "+ vm.getX());
    });

  }

}
