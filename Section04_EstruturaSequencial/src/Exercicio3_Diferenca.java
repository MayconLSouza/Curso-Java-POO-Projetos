import java.util.Scanner;

public class Exercicio3_Diferenca {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, d, diferenca;
		
		a = sc.nextInt();
		sc.nextLine();
		b = sc.nextInt();
		sc.nextLine();
		c = sc.nextInt();
		sc.nextLine();
		d = sc.nextInt();
		
		diferenca = (a * b - c * d);
		
		System.out.println("DIFERENCA = " + diferenca);
		
		sc.close();
		
	}

}
