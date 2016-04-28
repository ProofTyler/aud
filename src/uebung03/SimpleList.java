package uebung03;

import java.util.Optional;

public class SimpleList implements List {
	Integer n;
	Optional<SimpleList> rest;
	public SimpleList(Integer n, Optional<SimpleList> rest){
		this.n = n;
		this.rest = rest;
	}

	public static void main(String[] args) {
		SimpleList list1 = 
				new SimpleList(1, null);

	}

	@Override
	public void add(Integer value) {
		if( !rest.isPresent()){
			rest = Optional.of(new SimpleList(value, Optional.empty()));
		} else {
			rest.get().add(value);
		}		
	}

	@Override
	public Integer get(Integer index) {
		if(index == 0){
			return n;
		}else {
			return rest.get().get(index - 1);
		}
	}
	
	@Override
	public void remove(Integer index) {
		/*
		if(index == 0) throw new IllegalArgumentException(
				"Der erste Knoten kann nicht gelöscht werden!");
		if(index == 1){
			rest = rest.rest;
		} else {
			rest.remove(index - 1); 
		}
		*/		
	}

	@Override
	public String toString() {
		return n + (rest != null ? rest.toString() : "");
	}
	

}
