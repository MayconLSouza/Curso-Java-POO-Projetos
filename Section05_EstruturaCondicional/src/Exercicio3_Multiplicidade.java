import java.util.Scanner;

public class Exercicio3_Multiplicidade {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		if((a % b) == 0) {
			System.out.println("Sao Multiplos");
		} else {
			if((b % a) == 0) {
				System.out.println("Sao Multiplos");
			} else {
				System.out.println("Nao sao Multiplos");
			}
			
		}
		
		sc.close();

	}

}
