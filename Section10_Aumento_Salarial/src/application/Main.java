package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitites.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("How many employess will be registered? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("\nEmployee #%d:", (i+1));
			System.out.print("\nId: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			employees.add(new Employee(id, name, salary));
		}
		
		System.out.print("\nEnter the employee id that will have salary increase: ");
		int idSalaryIncrease = sc.nextInt();
		boolean idExists = false;
		
		for(Employee e : employees) {
			if(e.getId() == idSalaryIncrease) {
				System.out.print("Enter the percentage: ");
				double percentage = sc.nextDouble();
				double newSalary = e.getSalary() + (e.getSalary() * percentage / 100);
				e.setSalary(newSalary);
				idExists = true;
			}
		}
		
		if(!idExists) {
			System.out.println("This id does not exist");
		}
		
		System.out.println("\nList of employees: ");
		for(Employee e : employees) {
			System.out.println(e.toString());
		}
		
		sc.close();
	}

}
