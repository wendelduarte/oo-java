package exrciciosCursoJava.ExercicioContaBancaria.application;

import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.ExercicioContaBancaria.entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter account number: ");
		int accountNumber = Integer.parseInt(sc.nextLine());
		
		Account account = new Account(accountNumber, 0);
		
		System.out.print("Enter account holder: ");
		account.setName(sc.nextLine());
		
		System.out.print("Is there an initial deposit? (y/n) ");
		char d = sc.next(".").charAt(0);
		
		if(Character.toUpperCase(d) == 'Y') {
			System.out.print("Enter initial deposit value: ");
			account.addBalance(sc.nextFloat());
		}
		
		System.out.println("Account data: ");
		System.out.println(account);
		
		System.out.print("Enter a deposit value: ");
		account.addBalance(sc.nextFloat());
		
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		System.out.print("Enter a withdraw value: ");
		boolean withdraw = account.withdrawValue(sc.nextFloat());
		
		if(!withdraw) {
			System.out.println("You do not has limit to this withdraw ");
		}
		
		System.out.println("Updated account data: ");
		System.out.print(account);
		
		
		sc.close();
	}

}
