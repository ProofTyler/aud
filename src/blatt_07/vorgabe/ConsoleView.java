package blatt_07.vorgabe;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
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


public class ConsoleView extends GridPane {
  private Control control;
  
  private Button    insertButton     = new Button("Insert");
  private TextField insertTextfield  = new FormattedTextField(FormattedTextField.NumberPat, 15);
  private Button    removeButton     = new Button("Remove");
  private Label     valueLabel       = new Label("");
  private Label     msgLabel         = new Label("");
  
  private Stage     treeStage        = null;
  
  public ConsoleView(Control control) {
    this.control = control;
    
    setPadding(new Insets(10, 10, 10, 10));
    setHgap(10);
    setVgap(10);

    insertTextfield.setEditable(true);
    insertButton.setOnAction(
        (event) -> {
          msgLabel.setText("");
          String nS = insertTextfield.getText();
          try {
            int n = Integer.parseInt(nS);
            control.insert(n);
            TreeView<Integer> treeView = this.control.getTree();
            Scene secondScene = new Scene(treeView);
            if (treeStage != null) {
              treeStage.close();
              treeStage = null;
            }
            treeStage = new Stage();
            treeStage.setTitle("Heap");
            treeStage.setScene(secondScene);
            treeStage.show();
          } catch (NumberFormatException e) {
            msgLabel.setText("Illegal value to be inserted");
          }
        }
      );
    add(insertButton, 0, 0);
    add(insertTextfield, 1, 0);
    add(removeButton, 0, 1);
    removeButton.setOnAction(
        (event) -> {
          msgLabel.setText("");
            control.remove();
            TreeView<Integer> treeView = this.control.getTree();
            Scene secondScene = new Scene(treeView);
            if (treeStage != null) {
              treeStage.close();
              treeStage = null;
            }
            treeStage = new Stage();
            treeStage.setTitle("Heap");
            treeStage.setScene(secondScene);
            treeStage.show();
        }
      );
    add(valueLabel, 1, 1);
    add(msgLabel, 0, 2);
    
    setHalignment(insertButton, HPos.RIGHT);
    setHalignment(removeButton, HPos.RIGHT);
    setHalignment(msgLabel, HPos.RIGHT);
  }
  
  public void setValueLabel(String msg) {
    valueLabel.setText(msg);
  }

  public void setMsgLabel(String msg) {
    msgLabel.setText(msg);
  }

}
