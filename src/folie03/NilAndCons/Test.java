package folie03.NilAndCons;

public class Test {

	public static void main(String[] args) {
		IntList lst = new Cons(2, new Cons(3, new Nil()));
		System.out.println(Integer_List.lenght(lst));
		System.out.println(Integer_List.sum(lst));
		
		IrgendEinObj obj = new IrgendEinObj(3);
		IrgendEinObj obj2 = new IrgendEinObj(4);
		
		GenList lst2 = new GenCons(obj2.wert, new GenCons(obj.wert, new GenNil()));
		System.out.println(Gen_List.maximum(lst2));
	}

}
