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
			
			//sale.forEach(System.out::println);
			//Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
			
			
			//Integer pro = (Integer)(sale.stream().reduce(1, Integer::max));
			
			List<Sale> vendas2016  = sale.stream()
				//.filter(p -> p.averagePrice() > avg)  // filtra os preços abaixo do avg
				//.map(p -> p.toString())     // Pega os nomes que estão no filtro    
				//.sorted(Comparator.comparing(;)
				//.sorted((p1, p2) -> (p1.averagePrice().compareTo(p2.averagePrice())
				//.reduce(1, Integer::max)
				.filter(p -> p.getYear() == 2016 && p.averagePrice() > 0)
				//.map(p -> p.getYear())
				//.sorted(Comparator.comparing(Sale::averagePrice()))
				//.sorted(Comparator.comparing(Sale::averagePrice)).reversed())
				.sorted(Comparator.comparing(Sale::averagePrice).reversed())
				.limit(5)  
                 // compara na ordem decrescente
				.collect(Collectors.toList());

			vendas2016.forEach(System.out::println); // Mostrar na tela
			
			System.out.println(); // Saltar uma linha
			System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " );
			/*
			List<Sale> vendas = sale.stream()
					.filter(x -> x.getSeller().equals("Logan")
					.sorted(Comparator.comparing(Sale::getSeller).reversed())
					.collect(Collectors.toList());
			*/
			//vendas.forEach(System.out::println);
			//System.out.println(vendas.toString());
			
			testOne(sale);
	       
			//sale.forEach(sale.getSeller());
			
			//double order;
			// sale.stream().map()
			//double sum = sale.stream()
					// .comparator<Sale> sale (s1, s2) ->
					// s1.averagePrice().toUpperCase().compareTo(s2.averageCase().toUpperCase())
					// .max(Comparator.reverseOrder())
					// .sale.sort((s1, s2) ->
					// s1.averagePrice().toUpperCase().compareTo(s2.averageCase().toUpperCase()))
					// .sale(order);
				//	.limit(5).map(s -> s.averagePrice()).reduce(0.0, (x, y) -> x + y);
			// .collect(Collectors.toList());

			// .reduce(0.0, (x,y) -> x + y) / sale.size(); // Achando a média da soma de
			// todos elementos
			// .colect(Collector sale)

		

			// sale.sort(Sale::compareSale);
			//sale.sort((s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice()));
			//sale.forEach(System.out::println);

			//System.out.printf("Média da soma de todos os elementos = %.2f\n", sum);
			
			/*
			 * for(Sale x : sale) { System.out.println(x); }
			 */

		} catch (IOException e) { // Capturando o erro e exibindo uma mensagem
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}
	private static void testOne(List<Sale> sale) {

        Double total = 0.0;
        
    	
		List<Sale> vendasLogan = sale.stream()
				.filter(x -> x.getSeller().equals("Logan") && (x.getMonth().equals(1) || x.getMonth().equals(7)))
				.sorted(Comparator.comparing(Sale::getMonth))
				.collect(Collectors.toList());
		
		for(Sale sx : vendasLogan) {
			
			total += sx.getTotal();
		}
		System.out.println(vendasLogan.toString());        
        System.out.printf("Sum of Salaries is %.2f", total);
    }

}
