package blatt_06.aufgabe_06_vorgabe.view;

import blatt_06.aufgabe_06_vorgabe.Control;
import blatt_06.aufgabe_06_vorgabe.model.Model;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class FormattedTextField extends TextField {
  
  public static String NumberPat = "[0-9]";
  public static String TextPat = "[a-zA-Z]";
  
  private String format;
  private int size;

  public FormattedTextField(String format, int... size) {
    this.format = format; 
    this.size = 0;
    if (size.length == 1 && size[0] > 1) {
      this.size = size[0];
      super.setPrefColumnCount(size[0]);
    }
  }
    
  @Override 
  public void replaceText(int start, int end, String text) {
    if (text.matches(format) || text == "") {
      if (size <= 0 || getText().length() < size) {
        super.replaceText(start, end, text);
      }
    }
  }

  @Override 
  public void replaceSelection(String text) {
    if (text.matches(format) || text == "") {
      if (size <= 0 || getText().length() < size) {
        super.replaceSelection(text);
      }
    }
  }
 }


public class StartView extends GridPane {
  private Button startButton        = new Button("Start new board");
  private Label  sizeLabel          = new Label("Size");
  private TextField sizeTextfield   = new FormattedTextField(FormattedTextField.NumberPat, 15);
  private Label  msgLabel           = new Label("");
  
  public StartView() {
    setPadding(new Insets(10, 10, 10, 10));
    setHgap(10);
    setVgap(10);

    sizeTextfield.setEditable(true);
    startButton.setOnAction(
        (event) -> {
          msgLabel.setText("");
          String nS = sizeTextfield.getText();
          try {
            int n = Integer.parseInt(nS);
          if (n<1 || n>8) {
            msgLabel.setText("ILLEGAL n");
          } else {
            BoardView boardView = new BoardView(n);
            Model model     = new Model(n, boardView);
            Control control = new Control(n);
            control.setModel(model);
            control.setView(boardView);
            model.addObserver(boardView);
            boardView.setControl(control);

            Scene secondScene = new Scene(boardView);
            Stage secondStage = new Stage();
            secondStage.setTitle("Board");
            secondStage.setScene(secondScene);
            secondStage.show();
          }
          } catch (NumberFormatException e) {
            msgLabel.setText("Insert legal size");
          }
        }
      );
    add(sizeLabel, 0, 0);
    add(sizeTextfield, 1, 0);
    add(startButton, 0, 1);
    add(msgLabel, 1, 1);
    
    setHalignment(sizeLabel, HPos.RIGHT);
    setHalignment(startButton, HPos.RIGHT);
    setHalignment(msgLabel, HPos.RIGHT);
  }
}
