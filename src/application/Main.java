package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

  private static final String APPLICATION_NAME = "GVS";

  @Override
  public void start(Stage primaryStage) {

    try {
      // Load FXML file
      String fxmlSource = "/application/view/Application.fxml";
      FXMLLoader loader = new FXMLLoader();
      AnchorPane root = (AnchorPane) loader
          .load(getClass().getResourceAsStream(fxmlSource));

      // Show the scene containing the root layout.
      Scene scene = new Scene(root);
      primaryStage.setTitle(APPLICATION_NAME);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
