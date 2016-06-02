package blatt_07.vorgabe;

import javafx.scene.control.TreeView;

public class Control {
  private HeapPriorityQueue<Integer> model;
  private ConsoleView view;
  
  public Control(HeapPriorityQueue<Integer> model) {
    this.model = model;
  }

  public void insert(int n) {
    model.offer(n);
  }

  public void remove() {
    Integer top = model.poll();
    if (top != null) {
      view.setValueLabel(top.toString());
    } else {
      view.setMsgLabel("Queue is empty");
    }
  }

  
  public TreeView<Integer> getTree() {
    return model.toTreeView();
  }

  public void setView(ConsoleView view) {
    this.view = view;
  }
  
  

}
