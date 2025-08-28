package whileStruct;

import java.util.Scanner;

public class Exercicio2_Quadrante {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		while (x != 0 && y != 0) {
			
			if (x > 0 && y > 0) {
				System.out.println("primeiro");
			} else if (y > 0) {
				System.out.println("segundo");
			} else if (x > 0) {
				System.out.println("quarto");
			} else {
				System.out.println("terceiro");
			}

			sc.nextLine();

			x = sc.nextInt();
			y = sc.nextInt();
		}

		sc.close();

	}

}
