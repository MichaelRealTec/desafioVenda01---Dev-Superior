package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		// desafioVendas1 - DevSuperior

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String path;

		System.out.print("Entre o caminho do arquivo: ");
		path = sc.nextLine();
		System.out.println();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // Criando um arquivo de leitura recebendo
																				// como parametro o caminho do arquivo
																				// path

			List<Sale> sale = new ArrayList<>();

			String line = br.readLine(); // Variável linha para percorrer as linhas do arquivo

			while (line != null) { // Enquanto a linha for diferente de vazio repita o processo
				String[] fields = line.split(",");
				sale.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2],
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
				line = br.readLine(); // Pula para a leitura da próxima linha
			}

			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");

			List<Sale> vendas2016 = sale.stream().filter(p -> p.getYear() == 2016 && p.averagePrice() > 0)
					.sorted(Comparator.comparing(Sale::averagePrice).reversed()).limit(5)
					// compara na ordem decrescente
					.collect(Collectors.toList());

			vendas2016.forEach(System.out::println); // Mostrar na tela

			System.out.println(); // Saltar uma linha
			System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", testOne(sale));

		} catch (IOException e) { // Capturando o erro e exibindo uma mensagem
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

	// Utilizando método static passando como parametro a lista do tipo <Sale>
	private static double testOne(List<Sale> sale) {

		Double total = 0.0;

		List<Sale> vendasLogan = sale.stream()
				.filter(x -> x.getSeller().equals("Logan") && (x.getMonth().equals(1) || x.getMonth().equals(7))) // Filtrando
																													// os
																													// itens
																													// necessários
				.sorted(Comparator.comparing(Sale::getMonth)).collect(Collectors.toList()); // Colocando em ordem por
																							// mês os dados da venda

		for (Sale sx : vendasLogan) {

			total += sx.getTotal(); // Criando um laço de repetição para armazenar a soma das vendas do vendedor
									// Logan
		}

		return total;
		// System.out.println(vendasLogan.toString()); // Opcional, exibir na tela as
		// vendas feita por Logan no mês 1 e 7 de todos os meses
	}

}
