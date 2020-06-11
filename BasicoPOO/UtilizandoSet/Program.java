package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> a = new HashSet<Integer>();
		Set<Integer> b = new HashSet<Integer>();
		Set<Integer> c = new HashSet<Integer>();
		
		System.out.print("How many students for course A? ");
		Integer studentsQuantity = sc.nextInt();

		for(int i = 0; i<studentsQuantity; i++) {
			a.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B? ");
		studentsQuantity = sc.nextInt();

		for(int i = 0; i<studentsQuantity; i++) {
			b.add(sc.nextInt());
		}

		System.out.print("How many students for course C? ");
		studentsQuantity = sc.nextInt();

		for(int i = 0; i<studentsQuantity; i++) {
			c.add(sc.nextInt());
		}

		Set<Integer> totalStudents = new HashSet<>(a);
		totalStudents.addAll(b);
		totalStudents.addAll(c);
		
		System.out.println("Total students: " + totalStudents.size());
		
		sc.close();
	}

}
