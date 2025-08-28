package forStruct;

import java.util.Scanner;

public class Exercicio5_Fatorial {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n, fatorial = 1;
		n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			fatorial *= i;
		}
		
		if(n == 0 || n == 1) {
			System.out.println(1);
		} else {
			System.out.println(fatorial);
		}
		
		sc.close();

	}

}
