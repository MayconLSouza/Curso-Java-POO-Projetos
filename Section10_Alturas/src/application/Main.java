package application;

import java.util.Scanner;

import entities.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		double sum = 0.0;
		
		Pessoa[] pessoas = new Pessoa[n];
		
		for(int i = 0; i < pessoas.length; i++) {
			System.out.printf("Dados da %da pessoa:", i+1);
			System.out.print("\nNome: ");
			String nome = sc.next();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			pessoas[i] = new Pessoa(nome, idade, altura);
			sum += altura;
		}
		
		double avg = sum / n;
		System.out.printf("\nAltura média: %.2f", avg);
		
		int menos16 = 0;
		
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getIdade() < 16) {
				menos16++;
			}
		}
		
		double percentual = (menos16 * 100) / n;
		System.out.printf("\nPessoas com menos de 16 anos: %.1f%% \n", percentual);
		
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getIdade() < 16) {
				System.out.println(pessoas[i].getNome());
			}
		}
		
		sc.close();
	}

}
