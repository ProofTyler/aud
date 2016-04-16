package uebung01;

public class Aufg1 {

	public static void main(String[] args) {
		double area = Calculus.integral(
				new Calculus.Function(){

					@Override
					public double apply(double x) {
						return Math.sqrt(x);
					}
					
				},
				0.0,1.0);
		System.out.println("Berechnet:" + area);
		System.out.println("zum Vergleich exakt:" + 2.0/3.0);

	}

}
