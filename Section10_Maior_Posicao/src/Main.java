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
		
		double maior = vet[0];
		int posicao = 0;
		for(int i = 1; i < vet.length; i++) {
			if(vet[i] > maior) {
				maior = vet[i];
				posicao = i;
			}
		}
		
		System.out.println("\nMAIOR VALOR = " + maior);
		System.out.print("POSICAO DO MAIOR VALOR = " + posicao);
		
		sc.close();
	}

}
