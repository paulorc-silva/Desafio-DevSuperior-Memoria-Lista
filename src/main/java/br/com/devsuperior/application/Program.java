package br.com.devsuperior.application;

import br.com.devsuperior.desafios.poo.contribuintes.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> taxPayers = new ArrayList<>();
		int count;

		System.out.print("Quantos contribuintes você vai digitar? ");
		int numberOfTaxPayers = sc.nextInt();

		for (count = 1; count <= numberOfTaxPayers; count++) {
			System.out.printf("\nDigite os dados do %do contribuinte:%n", count);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			double serviceIncome = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();

			TaxPayer taxPayer = new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthSpending, educationSpending);
			taxPayers.add(taxPayer);
		}

		sc.close();
		count = 1;

		for (TaxPayer taxPayer : taxPayers) {
			System.out.printf("%nResumo do %do contribuinte:%n", count);
			System.out.printf("Imposto bruto total: %.2f%n", taxPayer.grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayer.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", taxPayer.netTax());
			count++;
		}
	}
}
