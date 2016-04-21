package uebung02;

public class Aufg5 {
	/*
	 * GGT(m,n)
	 * fm = Primfaktoren von m
	 * fn = Primfaktoren von n
	 * return Alle Primfaktoren von fn und fm
	 */
	
	
	/* Aufg 5.1
	 * Kein Algorithmus:
	 * - Ist fm,fn eine Menge oder Liste ...?
	 *   Nicht EINDEUTIG mit was ich es zu tun habe!
	 *   
	 * - Alle Primfaktoren von fn und fm?
	 *   Welches davon ist dann das Ergebnis?
	 *   Mache ich eine Schnittmenge oder andere
	 *   Berechnungen?
	 */
	
	public static void main(String[] args) {
		System.out.println(ggt(28,21));
		System.out.println(modernGGT(28,21));

	}	
	
	/** Aufg 5.2
	 * GGT durch euklidischer Algorithmus:
	 * Ermittelt solange den größten Wert beider Zahlen 
	 * durch Subtraktion bis eins davon 0 wird.
	 * 
	 * @param z1 
	 * @param z2
	 * 
	 * @return Gebe die größte Zahl aus, 
	 * 		   wenn z1 oder z2 = 0
	 * 
	 */
	public static int ggt(int z1, int z2){
		if(z2 == 0){
			return z1;
		} else if(z1 == 0){
			return z2;
		} else if(z1 > z2){
			return ggt(z1-z2, z2);
		} else {
			return ggt(z1, z2 - z1);
		}
	}
	
	/** Alternative durch Rest
	 *  Ermittle solange den Restwert beider Zahlen
	 *  bis eins 0 wird
	 *  
	 * @param z1: 
	 * @param z2
	 * 
	 * @return Gebe die größte Zahl aus, 
	 * 		   wenn z1 oder z2 = 0
	 */
	public static int modernGGT(int z1, int z2){
		if (z2 == 0){
			return z1;
		} else {
			return modernGGT(z2, z1 % z2);
		}
	}
	
}
