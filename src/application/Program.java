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

		System.out.print("Entre o caminho do arquivo: ");
		path = sc.nextLine();
		// String path = "c:\\temp\\in.csv"; // O '\' chama comandos especiais
		// Stream<String> st1 = sale.stream().map(x -> x < limit(5));
		// int sum = sale.stream().reduce(0, (x, y) -> x + y);
		// System.out.println("Sum = " + sum);

		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Criando um arquivo de leitura recebendo
																				// como parametro o caminho do arquivo
																				// path

			List<Sale> sale = new ArrayList<>();

			String line = br.readLine(); // Variável linha para percorrer as linhas do arquivo

			while (line != null) { // Enquanto a linha for diferente de vazio repita o processo
				// System.out.println(Arrays.toString(line.limit(5).toArray())); // Faz a
				// leitura da linha
				// System.out.println(line);
				String[] fields = line.split(",");
				sale.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2],
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
				// sale.add(new Sale(Double.parseDouble(fields[5]));
				// System.out.println(sale);
				line = br.readLine(); // Pula para a leitura da próxima linha
				// System.out.println(line);
			}

			double order;
			// sale.stream().map()
			double sum = sale.stream()
					// .comparator<Sale> sale (s1, s2) ->
					// s1.averagePrice().toUpperCase().compareTo(s2.averageCase().toUpperCase())
					// .max(Comparator.reverseOrder())
					// .sale.sort((s1, s2) ->
					// s1.averagePrice().toUpperCase().compareTo(s2.averageCase().toUpperCase()))
					// .sale(order);
					.limit(5).map(s -> s.averagePrice()).reduce(0.0, (x, y) -> x + y);
			// .collect(Collectors.toList());

			// .reduce(0.0, (x,y) -> x + y) / sale.size(); // Achando a média da soma de
			// todos elementos
			// .colect(Collector sale)

			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");

			// sale.sort(Sale::compareSale);
			sale.sort((s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice()));
			sale.forEach(System.out::println);

			System.out.printf("Média da soma de todos os elementos = %.2f\n", sum);
			System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = ");
			/*
			 * for(Sale x : sale) { System.out.println(x); }
			 */

		} catch (IOException e) { // Capturando o erro e exibindo uma mensagem
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
