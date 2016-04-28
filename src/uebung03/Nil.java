package uebung03;

import uebung03.Aufg2.GenList;

public class Nil<T> implements GenList<T> {
	@Override
	public String toString() {
		return "Nil []";
	}
}