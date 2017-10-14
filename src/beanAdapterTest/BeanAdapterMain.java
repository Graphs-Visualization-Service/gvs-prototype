package beanAdapterTest;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.BeanPathAdapter;

public class BeanAdapterMain extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    // Main frame
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 400, 400);    
    
    // Show main frame
    primaryStage.setScene(scene);
    primaryStage.show();
    
    
    HBox topBox = new HBox();
    root.setTop(topBox);
    topBox.setSpacing(10);
    
    HBox bottomBox = new HBox();
    root.setBottom(bottomBox);
    bottomBox.setSpacing(10);
    
    AnchorPane middlePane = new AnchorPane();
    root.setCenter(middlePane);
    
    //model
    Vertex v = new Vertex();
    v.setLabel("My Name Is Vertex");
    Circle c = new Circle(100,100,10);
    middlePane.getChildren().add(c);
    Text t = new Text();
    t.setText("Hello");
    topBox.getChildren().add(t);
    
    // Button for test
    Button btn = new Button("Bind");
    btn.setOnAction(event -> {
      bind(c,t, v);
    });
    bottomBox.getChildren().add(btn);
   
    TextField labelField = new TextField();
    topBox.getChildren().add(labelField);
    
    labelField.setOnKeyReleased(event ->{
      String s = ((TextField)event.getSource()).getText();
      System.out.println(s);
      v.setLabel(s);
    });
    
  }

  private void bind(Circle c, Text t, Vertex v) {
    BeanPathAdapter<Vertex> vertexBinding = new BeanPathAdapter<>(v);
    vertexBinding.bindBidirectional("X", c.centerXProperty());
    vertexBinding.bindBidirectional("Y", c.centerYProperty());
    vertexBinding.bindBidirectional("Label",t.textProperty());
  }

 
}
