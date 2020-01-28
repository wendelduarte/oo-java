/*
 * Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um sumário do pedido conforme exemplo. Nota: O instate do pedido deve ser
 * o instante do sistema.
 * 
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatusEnum;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Enter client data: ");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int quantityOrders = sc.nextInt();
		sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatusEnum.valueOf(status), client);
		
		for (int i = 1; i<=quantityOrders; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderItem = new OrderItem(productQuantity, product);
	
			orderItem.subTotal();
			
			order.addItem(orderItem);
		}		
		
		System.out.println();
		System.out.println(order.toString());
		
		sc.close();
	}
}
