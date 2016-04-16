package uebung01;

import java.util.Scanner;

public class Aufg3 {

	public static void main(String[] args) {
		Polynom p = new Polynom(1,2,3);
		System.out.println(p.valueAt(1.3));
	}

}

class Polynom {
	public double[] a;
	
	public Polynom(double... a){
		this.a = new double[a.length];
		int i = 0;
		for(double a_i : a) {
			this.a[i++] = a_i;
		}
	}
	
	public double valueAt(double x) {
		double val = 0.0;
		for(double ai: a) {
			val = ai + val *x;
		}
		return val;
	}
}
