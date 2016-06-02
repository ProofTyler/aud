package blatt_06.aufgabe_06_vorgabe;

import blatt_06.aufgabe_06_vorgabe.view.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Queens_App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Queens");
    
    StartView view       = new StartView();
    Scene scene = new Scene(view);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
