import java.util.Scanner;

public class Exercicio6_AreasGeometricas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		float a, b, c, area;
		
		a = sc.nextFloat();
		b = sc.nextFloat();
		c = sc.nextFloat();
		
		// Triangulo
		area = a * c / 2;
		System.out.printf("TRIANGULO: %.3f", area);
		
		// Circulo
		area = (float) (Math.PI * (Math.pow(c, 2)));
		System.out.printf("\nCIRCULO: %.3f", area);
		
		// Trapezio
		area = (a + b) * c / 2;
		System.out.printf("\nTRAPEZIO: %.3f", area);
		
		// Quadrado
		area = b * b;
		System.out.printf("\nQUADRADO: %.3f", area);
		
		// Retangulo
		area = a * b;
		System.out.printf("\nRETANGULO: %.3f", area);
		
		sc.close();

	}

}
