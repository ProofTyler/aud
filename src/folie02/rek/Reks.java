package folie02.rek;

public class Reks {

	public static void main(String[] args) {
		int n = 4;
		int a = fak(n);
		System.out.println("Fakultät von " + n + " gleich: " + a);
		int b = quad(n);
		System.out.println("Quadrant von " + n + " gleich: " + b);
	}

	private static int quad(int n) {
		if(n == 0)return 0;
		else return quad(n-1)+ 2*(n-1) +1;
	}

	private static int fak(int n) {
		if(n == 1){
			return 1;
		}else {
			return fak(n-1)*n;
		}
	}

}
