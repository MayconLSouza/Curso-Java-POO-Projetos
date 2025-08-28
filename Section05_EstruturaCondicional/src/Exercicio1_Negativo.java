import java.util.Scanner;

public class Exercicio1_Negativo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero;
		
		numero = sc.nextInt();
		
		System.out.println((numero < 0) ? "NEGATIVO" : "NAO NEGATIVO");
		
		sc.close();

	}

}
