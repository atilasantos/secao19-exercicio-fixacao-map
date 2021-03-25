package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Candidate;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		String filePath = sc.next();
		
		Map<String, Integer> candidates = new HashMap<String, Integer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String linhaDeLeitura = br.readLine();
			while(linhaDeLeitura != null) {
				
				String[] registroDeVotos = linhaDeLeitura.split(",");
				if(candidates.containsKey(registroDeVotos[0])) {
					candidates.replace(registroDeVotos[0], candidates.get(registroDeVotos[0]) + Integer.parseInt(registroDeVotos[1]));
					linhaDeLeitura = br.readLine();
					continue;
				}
				candidates.put(registroDeVotos[0], Integer.parseInt(registroDeVotos[1]));
				linhaDeLeitura = br.readLine();
			}
			String ultimoNome;
			for(String key: candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
		}
		catch (IOException e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}
