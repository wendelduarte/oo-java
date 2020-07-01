package exrciciosCursoJava.Polimorfismo.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exrciciosCursoJava.Polimorfismo.entities.ImportedProduct;
import exrciciosCursoJava.Polimorfismo.entities.Product;
import exrciciosCursoJava.Polimorfismo.entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		Product product = null;
		
		for (int i=1; i<=numberProducts; i++) {
			System.out.println("Product #" + i + "data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (typeProduct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufactureDate); 
			} else if (typeProduct == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsFee); 
			} else {
				product = new Product(name, price);
			}
			products.add(product);
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product p: products) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}

}
