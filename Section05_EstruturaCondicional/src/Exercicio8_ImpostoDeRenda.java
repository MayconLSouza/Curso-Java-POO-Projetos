import java.util.Scanner;

public class Exercicio8_ImpostoDeRenda {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double salario = sc.nextDouble();
		double imposto = 0.00;
		
		if(salario <= 2000.00) {
			System.out.println("Isento");
			System.exit(0);
		} 
		else if (salario <= 3000.0) {
			imposto = (salario - 2000.0) * 0.08;
		}
		else if (salario <= 4500.0) {
			imposto = (salario - 3000.0) * 0.18 + 1000.0 * 0.08;
		}
		else {
			imposto = (salario - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
		}
		
		System.out.printf("R$ %.2f", imposto);
		sc.close();
	}

}
