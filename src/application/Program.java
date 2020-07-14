package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;
import entities.Individual;
import entities.Company;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> lista = new ArrayList<>();
		
		System.out.print("Digite o número de contribuintes: ");
		int numeroContribuinte = sc.nextInt();
		
		for (int i=1; i<=numeroContribuinte; i++) {
			System.out.println("-------------------------------------");
			System.out.println("Informações do contribuinte #" + i);
			
			System.out.print("Individual ou companhia (I/C)? ");
			char tipo = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			
			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();
			
			if (tipo == 'I') {
				System.out.print("Gastos com saude: ");
				double gastoSaude = sc.nextDouble();
				lista.add(new Individual(nome, rendaAnual, gastoSaude));
			} else {
				System.out.print("Numero de funcionarios: ");
				int numeroFuncionarios = sc.nextInt();
				lista.add(new Company(nome, rendaAnual, numeroFuncionarios));
			}
		}
		System.out.println();
		
		double soma = 0.0;
		System.out.println("Taxas pagas");
		for (TaxPayer contribuintes : lista) {
			double taxa = contribuintes.taxa();
			System.out.println(contribuintes.getNome() + ": $ " + String.format("%.2f", taxa));
			soma += taxa;
		}
		
		System.out.println();
		System.out.println("Total de taxas: $" + String.format("%.2f", soma));
		
		sc.close();
	}

}
