package application;

import java.util.Scanner;

import entity.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		
		System.out.print("Name: ");
		employee.setName(sc.nextLine());
		System.out.print("Gross salary: ");
		employee.setGrossSalary(sc.nextDouble());
		System.out.print("Tax: ");
		employee.setTax(sc.nextDouble());
		
		System.out.println("\nEmployee: " + employee);
		System.out.print("\nWhich percentage to increase salary? ");
		employee.increaseSalary(sc.nextDouble());
		System.out.println("\nUpdated data: " + employee);
		
		sc.close();
		
	}

}
