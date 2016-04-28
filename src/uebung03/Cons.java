package uebung03;

import uebung03.Aufg2.GenList;

public class Cons<T> implements GenList<T> {
	@Override
	public String toString() {
		return "Cons [head=" + head + ", tail=" + tail + "]";
	}
	T head;
	GenList<T> tail;
	public Cons(T head, GenList<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public Integer getHead(Integer index){
		if(index == 0){
			return Integer.parseInt(head.toString());
		}else {
			Cons<T> nextTail = (Cons<T>)tail;
			return nextTail.getHead(index-1);
		}		
	}
	
	public GenList<T> getTail(Integer index){
		if(index == 0) throw new IllegalArgumentException("0 geht nicht, weil keine get cons da");
		if(index == 1){
			return tail;
		}else {
			Cons<T> thisTail = (Cons<T>)tail;
			return thisTail.getTail(index-1);
		}		
	}
}
