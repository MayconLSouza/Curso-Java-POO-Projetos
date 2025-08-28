import java.util.Scanner;

public class Exercicio4_HoraJogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int horaInicial, horaFinal, horaJogo;
		
		horaInicial = sc.nextInt();
		horaFinal = sc.nextInt();
		
		if(horaInicial == horaFinal) {
			System.out.println("O JOGO DUROU 24 HORA(S)");
		} else if (horaInicial > horaFinal) {
			horaJogo = (24 - horaInicial) + horaFinal;
			System.out.printf("O JOGO DUROU %d HORA(S)", horaJogo);
		} else {
			horaJogo = horaFinal - horaInicial;
			System.out.printf("O JOGO DUROU %d HORA(S)", horaJogo);
		}
		
		sc.close();

	}

}
