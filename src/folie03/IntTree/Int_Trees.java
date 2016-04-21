package folie03.IntTree;

interface IntTree {};

class Leaf implements IntTree {
	int value;
	Leaf(int value){
		this.value = value;
	}
}

class Node implements IntTree {
	IntTree left,right;
	public Node(IntTree left, IntTree right){
		this.left = left;
		this.right = right;
	}
}

public class Int_Trees {
	public static int sum(IntTree tree){
		if(tree instanceof Leaf){
			return ((Leaf)tree).value;
		}else{
			Node node = (Node)tree;
			return sum(node.left) + sum(node.right);
		}
	}
}
