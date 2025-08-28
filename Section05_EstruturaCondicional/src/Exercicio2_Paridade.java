import java.util.Scanner;

public class Exercicio2_Paridade {

	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		
		int numero = sc.nextInt();
		
		System.out.println(((numero % 2) == 0) ? "PAR" : "IMPAR");
		
		sc.close();

	}

}
