package exrciciosCursoJava.Exceptions.application;

import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.Exceptions.model.entities.Account;
import exrciciosCursoJava.Exceptions.model.exceptions.BalanceException;
import exrciciosCursoJava.Exceptions.model.exceptions.WithdrawLimitException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data ");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			System.out.println("");
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(sc.nextDouble());
			System.out.println("New balance: " + account.getBalance());
		} catch(WithdrawLimitException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (BalanceException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {
			sc.close();
		}
	}

}
