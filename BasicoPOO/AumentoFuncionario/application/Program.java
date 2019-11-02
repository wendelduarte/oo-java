package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registred? ");
		int quantityEmployee = sc.nextInt();
		
		List<Employee> employeeList = new ArrayList<>();
		
		for(int i = 0; i<quantityEmployee; i++) {
			sc.nextLine();
			System.out.println();
			System.out.printf("Employee #%d\n", i+1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			if(employeeList.size() > 0 || employeeList == null) {
				for(Employee x : employeeList) {
					while(id == x.getId()) {
						System.out.print("*This id already exist, try again: ");
						id = sc.nextInt();
						sc.nextLine();
					}
				}
			}

			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(id, name, salary);
			employeeList.add(employee);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idIncrease = sc.nextInt();
		sc.nextLine();	
		
		Employee emp = employeeList.stream().filter(x -> x.getId() == idIncrease).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This employee does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			emp.salaryIncrease(sc.nextDouble());
		}
		
		System.out.println();
		System.out.println("List of emplyees: ");
		for(Employee x : employeeList)
			System.out.println(x);
		
		sc.close();
	}

}
