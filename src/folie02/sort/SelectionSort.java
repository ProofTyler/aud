package folie02.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] zahlen = new int[]{4,5,8,1,3,2,6,7,9};
		/*
		SelectionSort.sort();
		for(int i = 0; i < zahlen.length; i++){
			System.out.println(zahlen[i]);
		}
		*/
		/*
		Student[] s = {
				new Student(13),
				new Student(0),
				new Student(40),
				new Student(14)
		};
		*/
		
	}
	
	public class Student {
		int alter;
		public Student(int alter){
			this.alter = alter;
		}
		
		private int getAlter() {
			return this.alter;
		}
		
		public int compareTo(Student student) {
			return student.getAlter();
		}
	}

	private static void sort(int[] a) {
		final int n = a.length;
		
		for(int i = 0; i < n; i++){
			int small = i;
			for(int j = i + 1; j < n; j++){
				if(a[j]<a[small]) { small = j; }
			}
			int t = a[small];
			a[small] = a[i];
			a[i] = t;
		}
	}
	
	private static <T extends Comparable<T>>void genSort(T[] a) {
		final int n = a.length;
		
		for(int i = 0; i < n; i++){
			int small = i;
			for(int j = i + 1; j < n; j++){
				if(a[j].compareTo(a[small]) < 0) { small = j; }
			}
			T t = a[small];
			a[small] = a[i];
			a[i] = t;
		}
	}
	
	

}
