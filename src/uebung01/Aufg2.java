package uebung01;

public class Aufg2 {
	public static void main(String[] args) {
		double area = CalculusJava8.integral(
				x -> Math.sqrt(x),
				0.0,1.0);
		System.out.println("Berechnet:" + area);
		System.out.println("zum Vergleich exakt:" + 2.0/3.0);

	}
}
