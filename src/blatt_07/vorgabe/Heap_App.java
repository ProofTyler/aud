package blatt_07.vorgabe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Heap_App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Play with Heaps");
    
    HeapPriorityQueue<Integer> model  = new HeapPriorityQueue<Integer>(10);
    Control     control               = new Control(model);
    ConsoleView controlView           = new ConsoleView(control);
    
    control.setView(controlView);
    
    FlowPane root = new FlowPane();
    root.getChildren().add(controlView);
    
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
