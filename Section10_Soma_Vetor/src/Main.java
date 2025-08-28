import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		double[] vet = new double[n];
		
		for(int i = 0; i < vet.length; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextDouble();
		}
		
		double sum = 0.0;
		double avg = 0.0;
		System.out.print("\nVALORES =");
		for(int i = 0; i < vet.length; i++) {
			System.out.printf(" %.1f", vet[i]);
			sum += vet[i];
		}
		
		avg = sum / n;
		
		System.out.printf("\nSOMA = %.2f", sum);
		System.out.printf("\nMEDIA = %.2f", avg);
		
		sc.close();
	}

}
