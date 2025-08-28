import java.util.Scanner;

public class Exercicio4_Salario {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numeroFuncionario, horasTrabalhadas;
		double valorHora, salario;
		
		numeroFuncionario = sc.nextInt();
		sc.nextLine();
		horasTrabalhadas = sc.nextInt();
		sc.nextLine();
		valorHora = sc.nextDouble();
		
		salario = horasTrabalhadas * valorHora;
		
		System.out.println("NUMBER = " + numeroFuncionario);
		System.out.println("SALARY = U$ " + salario);
		
		sc.close();

	}

}
