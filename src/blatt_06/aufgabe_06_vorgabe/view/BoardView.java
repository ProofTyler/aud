package blatt_06.aufgabe_06_vorgabe.view;

import blatt_06.aufgabe_06_vorgabe.Control;
import blatt_06.aufgabe_06_vorgabe.Position;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class BoardView extends Pane implements MapChangeListener<Position, Boolean> {

  private class Field extends StackPane {
    private Text text = new Text();
    
    public Field (int x, int y) {
      Rectangle border = new Rectangle(100, 100);
      border.setFill(null);
      border.setStroke(Color.BLACK);
      text.setFont(Font.font(35));
      setAlignment(Pos.CENTER);
      getChildren().addAll(border, text);
    }
  }  

  private Field[][] fields;
  
  private Label msgLabel = new Label("click to start / continue");
  private Button nextButton = new Button("next");

  private Control control;
  
  public void setControl(Control control) {
    this.control = control;
  }
  
  public BoardView(int n) {
    int sizeBase = n<4 ? 4 : n;
    setPrefSize(sizeBase*100, sizeBase*100+100+100);
    fields = new Field[n][n];
    
    for (int i = 0; i<n; i++) {
      for (int j = 0; j<n; j++) {
        fields[i][j] = new Field(i, j);
        fields[i][j].setTranslateX(j*100);
        fields[i][j].setTranslateY(i*100);
        getChildren().add(fields[i][j]);
      } 
    }
    msgLabel.setTranslateY(sizeBase*100+100+30);
    msgLabel.setTranslateX(10);
    msgLabel.setFont(Font.font ("Verdana", FontPosture.ITALIC, 14));
    getChildren().add(msgLabel);
    nextButton.setTranslateY(sizeBase*100+100+20);
    nextButton.setTranslateX(200);
    nextButton.setFont(Font.font ("Verdana", 18));
    nextButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          control.next();
        }
      });

    getChildren().add(nextButton);    
  }
    
  @Override
  public void onChanged(
      javafx.collections.MapChangeListener.Change<? extends Position, ? extends Boolean> change) {
        Position position = change.getKey();
        int x = position.getX();
        int y = position.getY();
        String mark = (! change.getValueAdded()) ? " " : "Q";   
        fields[x][y].text.setText(mark);
  }

  public void setMsg(String msg) {
    msgLabel.setText(msg);
  }


}
