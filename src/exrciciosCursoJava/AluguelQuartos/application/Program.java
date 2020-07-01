package exrciciosCursoJava.AluguelQuartos.application;

import java.util.Scanner;

import exrciciosCursoJava.AluguelQuartos.entities.Rent;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Rent[] rooms = new Rent[10];
		
		System.out.print("How many rooms will be rented? ");
		
		int quantityRooms = sc.nextInt();
		while (quantityRooms < 1 || quantityRooms > 10) {
			System.out.print("Invalid number. Try again: ");
			
			quantityRooms = sc.nextInt();
		}
		System.out.println();
		for (int i = 0; i<quantityRooms; i++) {
			sc.nextLine();
			System.out.printf("Rent #:%d\n", i+1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.print("Bedroom: ");
			rooms[sc.nextInt()] = new Rent(name, email);
			
			System.out.println();
		}
		
		System.out.println("Busy bedrooms:");
		
		for(int i = 0; i<rooms.length; i++) {
			if(rooms[i] != null) {
				System.out.println(i + ": " + rooms[i]);
			}
		}
		
		
		sc.close();
	}

}
