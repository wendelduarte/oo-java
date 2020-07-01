package exrciciosCursoJava.MembrosEstaticos.util;

public class CurrencyConverter {

	public static double dollarToReais(double dollar, double qtd) {
		double result = dollar * qtd;
		return result +(result*0.06);
		
	}
}
