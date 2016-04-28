package folie02.sort;

import java.util.Arrays;
import java.util.Comparator;

class Student {
	int age;
	String name;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}

}

public class InsertionSort {

	public static void main(String[] args){
		Student[] a = {
				new Student("Hugo", 3),
				new Student("Hugo", 0),
				new Student("Lisa", 1),
				new Student("Lisa", 8),
				new Student("Bernd", 7),
				new Student("Bernd", 2),
				new Student("Bernd", 5),
				new Student("Bernd", 4),
				new Student("Bernd", 9),
				new Student("Bernd", 6)
			
		};
		
		InsertionSort.sort(a,
				(a1,a2) -> {
					return a1.age - a2.age;
				});
		
		for(int i = 0; i<a.length;i++){
			System.out.print(a[i].age);
		}
	}
	//330172
	
	private static void sort(Student[] a, Comparator<Student> c) {
		final int n = a.length;		
		for(int i=0;i< n;i++){
			int j = 0;
			while(j<i && c.compare(a[j], a[i]) < 0) {
				j++;
			}			
			if(j!=i){
				Student t = a[i];
				for(int k=i;k>j;k--){
					a[k] = a[k-1];
				}
				a[j] = t;
			}
		}		
	}

	
}
