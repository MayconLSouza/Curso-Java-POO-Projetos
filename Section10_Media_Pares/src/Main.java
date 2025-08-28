import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos elementos vai ter o vetor? ");
		int n = sc.nextInt();
		int[] vet = new int[n];
		
		for(int i = 0; i < vet.length; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextInt();
		}
		
		int sum = 0;
		int cont = 0;
		boolean flag = false;
		
		for(int i = 0; i < vet.length; i++) {
			if(vet[i] % 2 == 0) {
				sum += vet[i];
				cont++;
				flag = true;
			}
		}
		
		
		
		if(flag == false) {
			System.out.print("NENHUM NUMERO PAR");
		} else {
			double avg = sum / cont;
			System.out.printf("MEDIA DOS PARES = %.1f", avg);
		}
		
		sc.close();
	}

}
