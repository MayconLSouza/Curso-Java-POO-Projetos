package forStruct;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio3_MediaPonderada {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		double[][] casoTeste = new double [n][3];
		double[] media = new double [n];
		double soma = 0.0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				casoTeste[i][j] = sc.nextDouble();
				if(j == 0) {
					soma += casoTeste[i][j] * 2.0;
				} else if (j == 1) {
					soma += casoTeste[i][j] * 3.0;
				} else {
					soma += casoTeste[i][j] * 5.0;
				}
			}
			media[i] = soma / 10.0;
			soma = 0;
			sc.nextLine();
		}
		
		
		for(int k = 0; k < n; k++) {
			System.out.printf("%.1f\n", media[k]);
		}
		
		// System.out.println(Arrays.toString(media));
		
		sc.close();

	}

}
