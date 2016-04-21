package folie03.NilAndCons;

interface IntList {}

class Nil implements IntList{}

class Cons implements IntList {
	int head;
	IntList tail;
	Cons(int head, IntList tail){
		this.head = head;
		this.tail = tail;
	}
}

class IrgendEinObj {
	int wert;
	public IrgendEinObj(int wert) {
		this.wert = wert;
	}
}

public class Integer_List {
	public static int lenght(IntList lst) {
		return (lst instanceof Nil) ? 0 : 1 + lenght( ((Cons)lst).tail );
	}
	
	public static int sum(IntList lst){
		if(lst instanceof Nil){
			return 0;
		} else {
			Cons cons = (Cons) lst;
			return cons.head + sum(cons.tail);
		}
	}
	
}