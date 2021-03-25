package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		final Integer NOME_CANDIDATO = 0;
		final Integer QUANTIDADE_DE_VOTOS = 1;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the file path: ");
		String caminhoDoArquivo = sc.next();

		Map<String, Integer> candidatos = new HashMap<String, Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoDoArquivo))) {

			String linhaDeLeitura = br.readLine();
			while (linhaDeLeitura != null) {

				String[] registroDeVotos = linhaDeLeitura.split(",");
				if (candidatos.containsKey(registroDeVotos[NOME_CANDIDATO])) {
					candidatos.replace(registroDeVotos[NOME_CANDIDATO], candidatos.get(registroDeVotos[NOME_CANDIDATO])
							+ Integer.parseInt(registroDeVotos[QUANTIDADE_DE_VOTOS]));
					linhaDeLeitura = br.readLine();
					continue;
				}
				candidatos.put(registroDeVotos[NOME_CANDIDATO], Integer.parseInt(registroDeVotos[QUANTIDADE_DE_VOTOS]));
				linhaDeLeitura = br.readLine();
			}
			
			for (String key : candidatos.keySet()) {
				System.out.println(key + ": " + candidatos.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
