package forStruct;

import java.util.Scanner;

public class Exercicio2_Intervalo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x, in = 0, out = 0;
		
		for(int i = 0; i < n; i++) {
			x = sc.nextInt();
			if(x >= 10 && x <= 20) {
				in++;
			} else {
				out++;
			}
		}
		
		System.out.println(in + " in");
		System.out.println(out + " out");
		
		sc.close();

	}

}
