package uebung01;

import uebung01.Calculus.Function;

public class Calculus {

	public interface Function {
		public double apply(double x);
	}

	public static double integral(Function f, double a, double b) {
		final int N = 100;
		double sum = 0.0;
		double delta = (b-a) / N;
		for(int i = 0; i < N; i++){
			double t = f.apply(a + i*delta);
			sum = sum + delta * t;
		}
		
		return sum;
	}	

}
