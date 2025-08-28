package application;

import java.util.Scanner;

import entities.Student;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		Student[] rents = new Student[10];
		
		for(int i = 0; i < n; i++) {
			System.out.printf("\nRent #%d:", i+1);
			System.out.print("\nName: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Room: ");
			int room = sc.nextInt();
			rents[room] = new Student(name, email, room);
		}
		
		System.out.print("\nBusy rooms:");
		for(int i = 0; i < rents.length; i++) {
			if(rents[i] != null) {
				System.out.printf("%n%d: %s, %s", rents[i].getRoom(), rents[i].getName(), rents[i].getEmail());
			}
		}
		
		sc.close();

	}

}
