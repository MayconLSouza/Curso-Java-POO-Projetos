import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		
		int pares = 0;
		int[] vet = new int[n];
		
		for(int i = 0; i < vet.length; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextInt();
		}
		
		System.out.println("\nNUMEROS PARES:");
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] % 2 == 0) {
				System.out.print(vet[i] + " ");
				pares++;
			}
		}
		
		System.out.print("\n\nQUANTIDADE DE PARES = " + pares);
		
		sc.close();
	}

}
