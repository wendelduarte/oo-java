package exrciciosCursoJava.Interfaces.src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.Interfaces.src.entities.Contract;
import exrciciosCursoJava.Interfaces.src.entities.Installment;
import exrciciosCursoJava.Interfaces.src.service.ContractService;
import exrciciosCursoJava.Interfaces.src.service.PaypalService;

public class Program {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		String date = sc.nextLine();
		System.out.print("Contract value: ");
		Double contractValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int numberOfInstallments = sc.nextInt();
		
		try {
			Contract cont = new Contract(number, date, contractValue, numberOfInstallments);
			ContractService contService = new ContractService(new PaypalService());
			
			contService.processInstallmentDate(cont);
			contService.processInstallmentAmount(cont);
			
			System.out.println("Installments: ");
			for(Installment inst : cont.getInstallments()) {
				System.out.println(sdf.format(inst.getDueDate()) + " - " + inst.getAmount());
			}
			
		}catch(ParseException e) {
			System.out.println("Erro ao processar a data: " + e);
		}
		sc.close();
	}
}
