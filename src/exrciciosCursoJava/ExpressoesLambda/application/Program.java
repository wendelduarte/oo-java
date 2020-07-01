package exrciciosCursoJava.ExpressoesLambda.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import exrciciosCursoJava.ExpressoesLambda.entities.Employee;

public class Program {
	
	private static final String PATH = "PUT YOUR PATH HERE /oo-java/src/exrciciosCursoJava/ExpressoesLambda/in.txt";
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter salary: ");
		Double salary = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader(new FileReader(PATH))){
			
			List<Employee> listEmployee = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				listEmployee.add(new Employee(fields[0], fields[1], Double.valueOf(fields[2])));
				line = br.readLine();
			}
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> emails = listEmployee.stream()
					.filter(employee -> employee.getSalary() > salary)
					.map(employee -> employee.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than 2000.00:");
			
			emails.forEach(System.out::println);
			
			double salarySum = listEmployee.stream()
					.filter(employee -> employee.getName().toUpperCase().charAt(0) == 'M')
					.map(employee -> employee.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("Sum of salary of people whose name stars with 'M': " + String.format("%.2f", salarySum));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}
}
