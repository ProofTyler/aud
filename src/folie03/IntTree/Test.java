package folie03.IntTree;

public class Test {

	public static void main(String[] args) {
		IntTree tree = new Node(
				new Node(new Leaf(3), new Leaf(6)), 
				new Node(new Leaf(1), new Leaf(5)) );
		
		System.out.println(Int_Trees.sum(tree));
	}

}
