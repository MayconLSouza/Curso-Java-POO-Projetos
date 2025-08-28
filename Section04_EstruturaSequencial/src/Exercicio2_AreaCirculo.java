import java.util.Scanner;

public class Exercicio2_AreaCirculo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double raio, area;
		
		raio = sc.nextDouble();
		
		area = Math.PI * (Math.pow(raio, 2));
		
		System.out.printf("A=%.4f", area);
		
		sc.close();

	}

}
