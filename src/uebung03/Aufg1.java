package uebung03;


public class Aufg1 {
	interface NatNum {
		static NatNum add(NatNum n, NatNum m){
			if(n instanceof Null)return m;				
			else {
				Next nn = (Next) n;
				return new Next(add(nn.previos,m));
			}
		}

		static NatNum toNatNum(int i) {
			if(i == 0){
				return new Null();
			}else{
				return new Next(toNatNum(i-1));
			}
		}
	}
	static class Null implements NatNum {
		@Override
		public String toString() {return "0";}	
	}
	static class Next implements NatNum {
		NatNum previos;
		Next(NatNum n) {
			this.previos = n;
		}
		@Override
		public String toString() 
		{return (Integer.parseInt(previos.toString())+1)+"";}
	}
	public static void main(String[] args) {
		NatNum x = new Next(new Next(new Null()));
		NatNum y = new Next(new Next(new Next(new Next(new Null()))));
		System.out.println(NatNum.add(x, y));
		
		NatNum a = NatNum.toNatNum(2);
		NatNum b = NatNum.toNatNum(4);
		System.out.println(NatNum.add(a, b));
	}

}
