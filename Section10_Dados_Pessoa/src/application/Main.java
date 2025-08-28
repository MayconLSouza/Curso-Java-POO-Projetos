package application;

import java.util.Scanner;

import entities.Pessoa;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas? ");
		int n = sc.nextInt();
		Pessoa[] pessoas = new Pessoa[n];
		
		for(int i = 0; i < pessoas.length; i++) {
			System.out.printf("Altura da %da pessoa: ", i+1);
			double altura = sc.nextDouble();
			System.out.printf("Genero da %da pessoa: ", i+1);
			char genero = sc.next().charAt(0);
			pessoas[i] = new Pessoa(altura, genero);
		}
		
		double menor = pessoas[0].getAltura();
		double maior = pessoas[0].getAltura();
		double sum = 0.0;
		int cont = 0;
		
		for(int i = 0; i < pessoas.length; i++) {
			if(pessoas[i].getAltura() < menor) {
				menor = pessoas[i].getAltura();
			}
			if(pessoas[i].getAltura() > maior) {
				maior = pessoas[i].getAltura();
			}
			if(pessoas[i].getGenero() == 'F') {
				sum += pessoas[i].getAltura();
				cont++;
			}
		}
		
		System.out.printf("Menor altura = %.2f", menor);
		System.out.printf("\nMaior altura = %.2f", maior);
		double avg = sum /cont;
		System.out.printf("\nMedia das alturas das mulheres = %.2f", avg);
		System.out.println("\nNumero de homens = " + (pessoas.length - cont));
		
		sc.close();
	}

}
