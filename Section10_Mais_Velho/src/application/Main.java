package application;

import java.util.Scanner;

import entities.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas voce vai digitar? ");
		int n = sc.nextInt();
		Pessoa[] pessoas = new Pessoa[n];
		
		for(int i = 0; i < pessoas.length; i++) {
			System.out.printf("Dados da %da pessoa:", i+1);
			System.out.print("\nNome: ");
			String nome = sc.next();
			System.out.print("Idade: ");
			int idade = sc.nextInt();
			pessoas[i] = new Pessoa(nome, idade);
		}
		
		int velho = pessoas[0].getIdade();
		int posicao = 0;
		for(int i = 1; i < pessoas.length; i++) {
			if(pessoas[i].getIdade() > velho) {
				velho = pessoas[i].getIdade();
				posicao = i;
			}
		}
		
		System.out.print("PESSOA MAIS VELHA: " + pessoas[posicao].getNome());
		
		sc.close();
	}

}
