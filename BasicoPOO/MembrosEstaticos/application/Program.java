package application;

import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Digite o valor do dolar: ");
		double dollar = sc.nextDouble();
		
		System.out.print("Digite a quantidade que deseja comprar: ");
		double qtd = sc.nextDouble();

		System.out.println("Para essa quantia terá que pagar em reais: " + CurrencyConverter.dollarToReais(dollar, qtd));

		
		sc.close();
	}

}
