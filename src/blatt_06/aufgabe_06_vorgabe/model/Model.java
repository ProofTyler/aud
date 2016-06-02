package blatt_06.aufgabe_06_vorgabe.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import blatt_06.aufgabe_06_vorgabe.Position;
import blatt_06.aufgabe_06_vorgabe.view.BoardView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

public class Model {
  
  private final int n;

  private Map<Position, Boolean>           board; 
  private ObservableMap<Position, Boolean> observableBoard;
  
  private List<int[]> placements;
  private Iterator<int[]> placementIter;
  
  public Model(int n, final BoardView view) {
    this.n = n;
    board = new TreeMap<Position, Boolean>();
    observableBoard = FXCollections.observableMap(board);

    Set<Integer> positions = new TreeSet<>();
    for (int i=0; i<n; i++)
      positions.add(i);
    for(int i = 0; i < n; i++) {
      for (int j = 0; j<n; j++) {
        observableBoard.put(new Position(i, j), false);
      }
    }
    Thread allQueensThread = new Thread( () -> {
      placements = new AllTuples(positions).ofLength(n);
      placementIter = placements.iterator();
      Platform.runLater(
          () -> { view.setMsg(""); }
        );
    });
    view.setMsg("Computing, please wait!");
    allQueensThread.start();
  }
  
  public void addObserver(MapChangeListener<Position, Boolean> boardObserver) {
    observableBoard.addListener(boardObserver);
  }
  
  public void next() {
    if (placementIter.hasNext()) {
      int[] nextPlacement = placementIter.next();
      for(int i = 0; i < n; i++) {
        for (int j = 0; j<n; j++) {
          observableBoard.put(new Position(i, j), false);
        }
      }
      int x = 0;
      for (int y: nextPlacement) {
        observableBoard.put(new Position(x,  y), true);
        x = x+1;
      }
    } else {
      throw new NoSuchElementException(); 
    }
  }
  
}
