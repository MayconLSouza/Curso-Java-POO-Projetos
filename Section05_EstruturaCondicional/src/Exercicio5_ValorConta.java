import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio5_ValorConta {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Double> cardapio = new HashMap<>();
		cardapio.put(1, 4.00);
		cardapio.put(2, 4.50);
		cardapio.put(3, 5.00);
		cardapio.put(4, 2.00);
		cardapio.put(5, 1.50);
		
		int codigo, quantidade;
		double total;
		
		codigo = sc.nextInt();
		quantidade = sc.nextInt();
		
		if(cardapio.containsKey(codigo)) {
			total = cardapio.get(codigo) * quantidade;
			System.out.printf("Total: R$ %.2f", total);
		} else {
			System.out.println("Código de produto não encontrado");
		}
		
		sc.close();

	}

}
