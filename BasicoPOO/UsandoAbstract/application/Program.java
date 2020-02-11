package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.IndividualPerson;
import entities.LegalEntity;
import entities.Person;

public class Program {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<>();
		double totalTaxes = 0;
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayers = sc.nextInt();
		
		for (int i = 1; i <= taxPayers; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Health expenditures: ");
				double healthSpending = sc.nextDouble();
				list.add(new IndividualPerson(name, annualIncome, healthSpending));
			} else {
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				list.add(new LegalEntity(name, annualIncome, employeeNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for (Person person : list) {
			System.out.println(person);
			totalTaxes += person.calcTax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);
		
		sc.close();
	}
}
