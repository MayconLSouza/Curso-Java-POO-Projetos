package application;

import java.util.Scanner;

import entity.Rectangle;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Rectangle rectangle = new Rectangle();
		
		System.out.println("Enter rectangle width and height: ");
		rectangle.setWidth(sc.nextDouble());
		rectangle.setHeight(sc.nextDouble());
		
		System.out.printf("AREA = %.2f\n", rectangle.calculateArea());
		System.out.printf("PERIMETER = %.2f\n", rectangle.calculatePerimeter());
		System.out.printf("DIAGONAL = %.2f\n", rectangle.calculateDiagonal());
		
		sc.close();
	}

}
