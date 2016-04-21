package uebung01;

public class Aufg5 {

	public static void main(String[] args) {
		System.out.println(new FolgeP().glied(5));
		System.out.println(new FolgePRek().glied(5));
		
		System.out.println(new FolgeFRek(new Folge() {
			@Override
			public double glied(int n) {
				return helper(n,n);
			}
			private double helper(int n, int k) {
				if(n==0)return 0;
				else return helper(n-1,k)+2*k*((n+1)-1);
			}
		}).glied(5));
		
		System.out.println(new FolgeF(new Folge() {
			@Override
			public double glied(int n) {
				return helper(n,n);
			}
			private double helper(int n, int k) {
				if(n==0)return 0;
				else return helper(n-1,k)+2*k*((n+1)-1);
			}
		}).glied(5));
		
		System.out.println(new FolgeF(new Folge() {
			@Override
			public double glied(int n) {
				int s = 0;
				for (int i = 0; i<=n;i++) s = s+2*n*i;
				return s;
			}
		}).glied(5));
	}

}

interface Folge {
	public double glied(int n);
}

class FolgeFRek implements Folge {
	private Folge a;
	
	public FolgeFRek(Folge a){
		this.a = a;
	}

	@Override
	public double glied(int n) {
		if(n==0) return 0;
		else return glied(n-1) + this.a.glied(n);
	}
	
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
		}
		return sum;
	}
	
}

class FolgePNeuRek implements Folge {
	@Override
	public double glied(int n) {
		return helper(n,n);
	}

	private double helper(int n, int k) {
		if(n==0)return 0;
		else return helper(n-1,k)+2*k*(n-1);
	}
}

class FolgePNeu implements Folge {
	@Override
	public double glied(int n) {
		int sum = 0;
		for(int k=0; k<n;k++){
			sum = sum + 2*n*k;
		}
		return sum;
	}
}

class FolgePRek implements Folge {
	@Override
	public double glied(int n) {
		if(n == 1)return 0;
		else return glied(n-1) + helper2(n,n);
	}

	private int helper2(int n, int k) {
		if(n==0)return 0;
		else return helper2(n-1,k)+2*k*(n-1);		
	}
}

class FolgeP implements Folge {
	@Override
	public double glied(int n) {
		int sum = 0;
		for (int i = 0; i<=n; i++){			
			for(int k=0; k<i;k++){
				sum = sum + 2*i*k;
			}
		}	
		return sum;
	}
}

class FolgeSRek implements Folge {
	@Override
	public double glied(int n) {
		if(n == 1){
			return 1;
		}else {
			return glied(n-1) + n;
		}		
	}	
}

class FolgeS implements Folge {
	@Override
	public double glied(int n) {
		int sum = 0;
		for(int i = 0; i <= n; i++){
			sum = sum + i;
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
