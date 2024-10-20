package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		// desafioVendas1 - DevSuperior

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String path;
		List<Sale> sale = new ArrayList<>();
		
		System.out.print("Entre o caminho do arquivo: ");
		path = sc.nextLine();
		//String path = "c:\\temp\\in.csv"; // O '\' chama comandos especiais

		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Criando um arquivo de leitura recebendo como parametro o caminho do arquivo path
			String line = br.readLine(); // Variável linha para percorrer as linhas do arquivo

			while (line != null) {  // Enquanto a linha for diferente de vazio repita o processo
				System.out.println(line); // Faz a leitura da linha
				line = br.readLine();  // Pula para a leitura da próxima linha
			}
			// sale.stream().map()
		} catch (IOException e) {  // Capturando o erro e exibindo uma mensagem
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
