package application;

import java.util.Scanner;

import entities.Aluno;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos alunos serao digitados? ");
		int n = sc.nextInt();
		sc.nextLine();
		Aluno[] alunos = new Aluno[n];
		
		for(int i = 0; i < alunos.length; i++) {
			System.out.printf("Digite nome, primeira e segunda nota do %do aluno:%n", i+1);
			String nome = sc.nextLine();
			double nota1 = sc.nextDouble();
			sc.nextLine();
			double nota2 = sc.nextDouble();
			sc.nextLine();
			alunos[i] = new Aluno(nome, nota1, nota2);
		}
		
		System.out.println("Alunos aprovados:");
		for(int i = 0; i < alunos.length; i++) {
			double media = (alunos[i].getNota1() + alunos[i].getNota2()) / 2;
			if(media >= 6.0) {
				System.out.println(alunos[i].getNome());
			}
		}
		
		sc.close();
	}

}
