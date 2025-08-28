package whileStruct;

import java.util.Scanner;

public class Exercicio01_Senha {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int senha = sc.nextInt();

		while (senha != 2002) {
			System.out.println("Senha Invalida");
			sc.nextLine();
			senha = sc.nextInt();
		}

		System.out.println("Acesso Permitido");

		sc.close();

	}

}
