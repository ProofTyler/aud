package blatt_06.aufgabe_06_vorgabe;

import java.util.NoSuchElementException;

import blatt_06.aufgabe_06_vorgabe.model.Model;
import blatt_06.aufgabe_06_vorgabe.view.BoardView;

public class Control {
  
  private Model model; 
  private BoardView view;
  
  public Control(int n) {
  }

  public void setView(BoardView view) {
    this.view = view;
  }

  public void setModel(Model model) {
    this.model = model;
  }
  
  
  public void next() {
    try {
      model.next();
    } catch (NoSuchElementException e) {
     view.setMsg("Finished");
    }
  }
}
