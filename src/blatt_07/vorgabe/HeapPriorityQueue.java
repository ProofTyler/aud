package blatt_07.vorgabe;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class HeapPriorityQueue <E extends Comparable<E>> extends AbstractQueue<E> {

private int capacity; // maximale Groesse
  private int size = 0; // aktuelle Groesse

  private E[]  h;
  private Queue<Integer> q;
  Comparator<Integer> comparator =
		  (a1,a2) -> {
				return a1 - a2;
			};
  /**
   * @param capacity                  die Kapazitaet der Warteschlange.
   * @throws IllegalArgumentException falls capacity <= 0
   */
  @SuppressWarnings("unchecked")
  public HeapPriorityQueue(int capacity) throws IllegalArgumentException{
    if (capacity <= 0) { throw new IllegalArgumentException(); }
    this.capacity = capacity;
    this.size = 0;
    this.h = (E[]) new Comparable[capacity];
    //this.q = new PriorityQueue<Integer>(capacity, comparator);
    this.q = new LinkedList<>();
  }

  /* (non-Javadoc)
   * @see java.util.Queue#offer(java.lang.Object)
   */
  @Override
  public boolean offer(E e) {
    return q.offer((Integer) e);
  }

  /* (non-Javadoc)
   * @see java.util.Queue#poll()
   */
  @Override
  public E poll() {
    return (E) q.poll();
  }

  /* (non-Javadoc)
   * @see java.util.Queue#peek()
   */
  /*
  @Override
  public E peek() {
    if (size == 0) return null;
    else return h[0];
  }
  */
  @Override
  public E peek() {
    if (size == 0) return null;
    else return (E) q.peek();
  }

  /* (non-Javadoc)
   * @see java.util.AbstractCollection#iterator()
   */
  @Override
  public Iterator<E> iterator() {
      //return Arrays.asList(Arrays.copyOf(h, size)).iterator();
	  return (Iterator<E>) q.iterator();
  }

  /* (non-Javadoc)
   * @see java.util.AbstractCollection#size()
   */
  @Override
  public int size() {
	size = q.size();
    return size;
  }  
  
  public TreeView<E> toTreeView() {
    TreeView<E> treeView = new TreeView<>();
    if (size() > 0) {
      TreeItem<E> root = toTreeViewFrom(0);
      treeView.setRoot(root);
      return treeView;
    } else {
      return treeView;
    }
  }

  private TreeItem<E> toTreeViewFrom(int i) {
	Iterator<E> itr = iterator();
	TreeItem<E> tree = new TreeItem<>();
	tree.setExpanded(true);
	while(itr.hasNext()){
		TreeItem<E> item = new TreeItem<E>(itr.next());
		tree.getChildren().add(item);
	}
	
    return tree;
  }
  
}
