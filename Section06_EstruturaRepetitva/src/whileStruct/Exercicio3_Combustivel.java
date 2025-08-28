package whileStruct;

import java.util.HashMap;
import java.util.Scanner;

public class Exercicio3_Combustivel {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> combustivel = new HashMap<>();

		combustivel.put(1, 0); // Álcool
		combustivel.put(2, 0); // Gasolina
		combustivel.put(3, 0); // Diesel

		int codigo = sc.nextInt();

		while (codigo != 4) {
			switch (codigo) {
			case 1:
				combustivel.put(1, combustivel.get(1) + 1);
				break;
			case 2:
				combustivel.put(2, combustivel.get(2) + 1);
				break;
			case 3:
				combustivel.put(3, combustivel.get(3) + 1);
				break;
			default:
				break;
			}

			codigo = sc.nextInt();
		}

		System.out.println("MUITO OBRIGADO");
		System.out.println("Alcool: " + combustivel.get(1));
		System.out.println("Gasolina: " + combustivel.get(2));
		System.out.println("Diesel: " + combustivel.get(3));

		sc.close();
	}

}
