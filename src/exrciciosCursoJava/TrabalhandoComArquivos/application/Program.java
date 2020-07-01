package exrciciosCursoJava.TrabalhandoComArquivos.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import exrciciosCursoJava.TrabalhandoComArquivos.entities.Product;

public class Program {

	private static final String PATH = "PUT YOUR PATH HERE";
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		try(BufferedReader br = new BufferedReader(new FileReader(PATH + "source.csv"))){
			
			List<Product> allContent = new ArrayList<Product>();
			
			String line = br.readLine();
			while(line != null) {
				String[] lineContent = line.split(",");
				allContent.add(new Product(lineContent[0], Double.valueOf(lineContent[1]), Integer.valueOf(lineContent[2])));
				line = br.readLine();
			}
			
			new File(PATH + "out").mkdir();
			new File(PATH + "out/summary.csv").createNewFile();
			for(Product item: allContent) {
			
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH + "out/summary.csv", true))){
					bw.write(item.getName() + "," + String.format("%.2f", item.totalValue()));
					bw.newLine();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
