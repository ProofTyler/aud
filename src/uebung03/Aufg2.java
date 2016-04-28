package uebung03;

import uebung03.Aufg1.NatNum;
import static uebung03.Aufg1.NatNum.*;
import static uebung03.Aufg2.GenList.*;
import java.util.Comparator;

public class Aufg2 {	
	interface GenList<T>{		
		static <T> GenList<T> cons(T head, GenList<T> tail) {
			return new Cons<T>(head, tail);
		}
		static <T> GenList<T> nil() {
			return new Nil<>();
		}
	}
	
	static <T> void selectionSortComparator(GenList<T> lst, Comparator<T> c) {
		GenList<T> i = (GenList<T>) lst;		
		while(! (i instanceof Nil)){
			Cons<T> lst_i = (Cons<T>)i;
			Cons<T> small = lst_i;
			GenList<T> j = lst_i.tail;
			while(! (j instanceof Nil)){
				Cons<T> lst_j = (Cons<T>)j;
				if(c.compare(lst_j.head, small.head)<0){
					small = lst_j;
				}
				j=lst_j.tail;
			}
			T t = small.head;
			small.head=lst_i.head;
			lst_i.head = t;
			i = lst_i.tail;
		}
	}
	public static <T> GenList<T> insertionSortComparator(GenList<T> lst, Comparator<T> c){GenList<T> i = (GenList<T>) lst;
		int ii = 0;
		while(! (i instanceof Nil)){			
			Cons<T> lst_i = (Cons<T>)i;
			Cons<T> lst_j = (Cons<T>) lst;
			int jj = 0;
			while(jj < ii && c.compare(lst_j.head, lst_i.head) < 0) {
				lst_j = (Cons<T>)lst_j.tail;
				jj++;
			}			
			if(jj != ii){
				T t = lst_i.head;
				Cons<T> lst_k = (Cons<T>)lst;
				for(int k=ii;k>jj;k--){
					Cons<T> cons_k = (Cons<T>) lst_k.getTail(k);
					if(k == 1) cons_k.head = lst_k.head;
					else cons_k.head = ((Cons<T>)lst_k.getTail(k - 1)).head;					
				}
				if(jj == 0) lst_k.head = t;
				else ((Cons<T>) lst_k.getTail(jj)).head = t;				
			}
			i = lst_i.tail;
			ii++;
		}
		return lst;
	}
	
	public static <T> GenList<T> sort(GenList<T> lst) {		
		return insertionSortComparator(lst, 
				(o1,o2) -> {
					return Integer.parseInt(o1.toString()) - Integer.parseInt(o2.toString());
				}
			);
	}

	public static void main(String[] args) {		
		GenList<NatNum> lst = cons(
				toNatNum(3), cons(
					toNatNum(2), cons(
						toNatNum(1), cons(
							toNatNum(5), cons(
								toNatNum(4), nil()
								)))));
		
		
		
		/*
		selectionSortComparator(lst, 
				(o1,o2) -> {
					return Integer.parseInt(o1.toString()) - Integer.parseInt(o2.toString());
				}
			);
		*/
		System.out.println(sort(lst));
		System.out.println(lst);
	}
	

	

}
