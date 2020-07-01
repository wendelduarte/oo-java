package exrciciosCursoJava.UtilizandoMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
	
	public static final String FILE_PATH = "put your path here";
	public static void main(String[] args) {

		try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			
			Map<String, Integer> candidateVotes = new HashMap<String, Integer>();
			
			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(",");
				
				if(candidateVotes.containsKey(fields[0])) {
					Integer votes = candidateVotes.get(fields[0]);
					votes += Integer.valueOf(fields[1]);
					candidateVotes.put(fields[0], votes);
				} else {
					candidateVotes.put(fields[0], Integer.valueOf(fields[1]));
				}
				
				line = br.readLine();
			}
			
			for(String key : candidateVotes.keySet()) {
				System.out.println(key + ": " + candidateVotes.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
