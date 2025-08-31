import java.util.Scanner;

public class Exercicio5_ValorPeca {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int qntdPeca1, qntdPeca2;
		double valorPeca1, valorPeca2, total;
		
		qntdPeca1 = sc.nextInt();
		valorPeca1 = sc.nextDouble();
		
		sc.nextLine();
		
		qntdPeca2 = sc.nextInt();
		valorPeca2 = sc.nextDouble();
		
		total = (qntdPeca1 * valorPeca1) + (qntdPeca2 * valorPeca2);
		
		System.out.printf("VALOR A PAGAR: R$ %.2f", total);
		
		sc.close();

	}

}
