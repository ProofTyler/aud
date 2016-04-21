package folie03.NilAndCons;

interface GenList<T> {}

class GenNil<T> implements GenList<T>{}

class GenCons<T> implements GenList<T> {
	T head;
	GenList<T> tail;
	GenCons(T head, GenList<T> tail){
		this.head = head;
		this.tail = tail;
	}
}

public class Gen_List {
	public static <T> int lenght(GenList<T> lst) {
		return (lst instanceof GenNil) ? 0 : 1 + lenght( ((GenCons<T>)lst).tail );
	}
	
	public static <T extends Comparable<T>> T maximum(GenList<T> lst){
		if(lst instanceof GenNil){
			throw new IllegalArgumentException("maybe not Empty");
		} else {
			GenCons<T> cons = (GenCons<T>)lst;
			if(cons.tail instanceof GenNil) return cons.head;
			else {
				T maxTail = maximum(cons.tail);
				return cons.head.compareTo(maxTail) > 0 ? cons.head : maxTail;
			}
			
		}
	}
	
}