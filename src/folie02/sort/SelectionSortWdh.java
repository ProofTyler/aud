package folie02.sort;

import java.util.Comparator;

class Record {
	String name;
	int age;
	
	public Record(String name, int age){
		this.name = name;
		this.age = age;
	}

}

class RecordComparator implements Comparator<Record> {

	@Override
	public int compare(Record o1, Record o2) {
		if (o1.name.compareTo(o2.name) == 0){
			return o1.age - o2.age;
		}else return o1.name.compareTo(o2.name);
	}
	
}

public class SelectionSortWdh {
	
	public static void main(String[] args) {
		/*
		int[] a = new int[]{5,7,9,6,1,8,4,2,3};
		SelectionSortWdh.sort(a);		
		*/		
		Record[] a = {
				new Record("Hugo", 6),
				new Record("Hugo", 5),
				new Record("Lisa", 7),
				new Record("Lisa", 1),
				new Record("Bernd", 2),
				new Record("Bernd", 3)
			
		};
		/*
		SelectionSortWdh.sortWithComparator(
				a,
				new RecordComparator());
		*/
		SelectionSortWdh.sortWithComparator(
				a, 
				(o1,o2) -> {
					if (o1.name.compareTo(o2.name) == 0){
						return o1.age - o2.age;
					}else return o1.name.compareTo(o2.name);
				}
			);		
		for(int i=0;i < a.length;i++){
			System.out.println(a[i].name + ": " + a[i].age);
		}

	}

	private static <T> void sortWithComparator(Record[] a, Comparator<Record> c) {
		final int n = a.length;		
		for(int i=0;i< n;i++){			
			int small = i;
			for(int j = i+1; j < n;j++){
				if( c.compare(a[j],a[small]) < 0 ) small = j;
			}			
			Record t = a[i];
			a[i] = a[small];
			a[small] = t;
		}
	}

	private static void sort(int[] a) {
		final int n = a.length;		
		for(int i=0;i< n;i++){			
			int small = i;
			for(int j = i+1; j < n;j++){
				if(a[small] > a[j]) small = j;
			}			
			int t = a[i];
			a[i] = a[small];
			a[small] = t;
		}
	}
	
	private static <T extends Comparable<T>>void genSort(T[] a) {
		final int n = a.length;		
		for(int i=0;i< n;i++){			
			int small = i;
			for(int j = i+1; j < n;j++){
				if( a[small].compareTo(a[j]) > 0 ) small = j;
			}			
			T t = a[i];
			a[i] = a[small];
			a[small] = t;
		}
	}
	
	
	private static <T> void genSort2(T[] a, Comparator<? super T> c) {
		final int n = a.length;		
		for(int i=0;i< n;i++){			
			int small = i;
			for(int j = i+1; j < n;j++){
				if( c.compare(a[small],a[j]) > 0 ) small = j;
			}			
			T t = a[i];
			a[i] = a[small];
			a[small] = t;
		}
	}

}
