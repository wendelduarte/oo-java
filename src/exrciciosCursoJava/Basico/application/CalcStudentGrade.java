package exrciciosCursoJava.Basico.application;

import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.Basico.entities.Student;

public class CalcStudentGrade {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		
		System.out.print("Enter your name: ");
		student.name = sc.nextLine();
		
		System.out.print("Enter your first grade: ");
		student.n1 = sc.nextDouble();
		
		System.out.print("Enter your second grade: ");
		student.n2 = sc.nextDouble();
		
		System.out.print("Enter your 3 grade: ");
		student.n3 = sc.nextDouble();
		
		System.out.println("Nota final = " + student.calcGrade());
		System.out.println(student.verifyGrade());
		sc.close();
	}

}
