import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos elementos vai ter o vetor? ");
		int n = sc.nextInt();
		double[] vet = new double[n];
		double sum = 0.0;
		
		for(int i = 0; i < vet.length; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextDouble();
			sum += vet[i];
		}
		
		double avg = sum / n;
		System.out.printf("\nMEDIA DO VETOR = %.3f", avg);
		
		System.out.println("\nELEMENTOS ABAIXO DA MEDIA:");
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] < avg) {
				System.out.println(vet[i]);
			}
		}
		
		sc.close();
	}

}
