//Exercico 2
package exrciciosCursoJava.Basico.application;

import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.Basico.entities.Employee;

public class ShowEmployeeData {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee employee = new Employee();
		
		System.out.print("Name: ");
		employee.name = sc.nextLine();
		System.out.print("Gross salary: ");
		employee.grossSalary = sc.nextDouble();
		System.out.print("Tax: ");
		employee.tax = sc.nextDouble();
		System.out.println(employee);
		System.out.println();
		System.out.print("Which percentage to increase salary? ");
		double percentage = sc.nextDouble();
		employee.increaseSalary(percentage);
		System.out.println("Update data: " + employee.name + ", $ " + employee.netSalary());
		
		sc.close();
	}

}
