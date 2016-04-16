package uebung01;

public class Aufg5 {

	public static void main(String[] args) {
		/*
		System.out.println(new FolgeA(5, 5, 5).glied(3));
		System.out.println(new FolgeP().glied(5));
		*/
		System.out.println(new FolgeF(new Folge() {
			@Override
			public double glied(int n) {
				int s = 0;
				for (int i = 0; i<=n;i++) s = s+2*n*i;
				return s;
			}
		}).glied(5));
		System.out.println("eine Änderung");
		
	}

}

interface Folge {
	public double glied(int n);
}

class FolgeF implements Folge {
	private Folge a;
	
	public FolgeF(Folge a){
		this.a = a;
	}

	@Override
	public double glied(int n) {
		double sum = 0;
		for(int i = 0;i<=n;i++){
			sum = (double) (sum + this.a.glied(i));
			System.out.println(sum);
		}
		return sum;
	}
	
}

class FolgeS implements Folge {
	private int i;
	
	public FolgeS(int i){
		this.i = i;
	}

	@Override
	public double glied(int n) {
		int sum = 0;
		for(int i = 0; i <= n; i++){
			sum = sum + this.i + this.i;
		}
		return sum;
	}
	
}

class FolgeP implements Folge {
	@Override
	public double glied(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++){
			
			for(int k=0; k<=i;k++){
				sum = sum + 2*i*k;
			}
		}	
		return sum;
	}
	
}

class FolgeA implements Folge {
	private double x;
	private double c;
	private double s;
	
	public FolgeA(double s,double x,double c){
		this.s = s;
		this.x = x;
		this.c = c;
	}
	
	@Override
	public double glied(int n) {
		if(n==0) return s;
		else return glied(n-1)*x +c;
	}
	
	@Override
	public String toString() {
		return "FolgeA ["+s+", "+x+", "+c+"]";
	}
}
