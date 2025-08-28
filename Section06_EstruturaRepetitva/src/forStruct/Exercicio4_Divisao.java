package forStruct;

import java.util.Scanner;

public class Exercicio4_Divisao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double dividendo, divisor;
		
		for(int i = 0; i < n; i++) {
			dividendo = sc.nextInt();
			divisor = sc.nextInt();
			if(divisor == 0) {
				System.out.println("divisao impossivel");
			} else {
				System.out.println(dividendo / divisor);
			}
		}
		
		sc.close();

	}

}
