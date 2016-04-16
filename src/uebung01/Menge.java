package uebung01;

import java.util.Arrays;

public class Menge {
	private int[] values;
	
	public Menge(int... values){
		this.values = values;
	}
	private boolean contain(int i) {
		for(int z : values){
			if(z == i) return true;
		}
		return false;
	}
	
	private Menge vereinigtMit(Menge m) {
		int count = this.values.length;
		for(int z: m.values){
			if(!this.contain(z))count++;
		}
		int[] temp = new int[count];
		int i = 0;
		for(int z : this.values){
			temp[i++] = z;
		}
		for(int z : m.values){
			if(!this.contain(z))
				temp[i++] = z;
		}
		Arrays.sort(temp);
		return new Menge(temp);
	}
	
	private Menge geschnittenMit(Menge m) {
		int count = 0;
		for(int z: m.values){
			if(this.contain(z))count++;
		}
		int[] temp = new int[count];
		int i = 0;
		for(int z : m.values){
			if(this.contain(z))
				temp[i++] = z;
		}
		Arrays.sort(temp);
		return new Menge(temp);
	}
	
	public static void main(String[] args) {
		Menge m1 = new Menge(1,2,3);
		Menge m2 = new Menge(3,4,10,11);
		Menge m3 = new Menge(7,9,6);
		Menge m = m1.geschnittenMit(m2);		
		for(int z: m.values){
			System.out.print(z+", ");
		}
		
		Menge m4 = new Menge(1,2,3,4);
		Menge m5 = new Menge(2,3);
		
	}
	


	

	

}
