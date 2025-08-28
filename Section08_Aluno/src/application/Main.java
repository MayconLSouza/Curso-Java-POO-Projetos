package application;

import java.util.Scanner;

import entity.Student;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		
		student.setName(sc.next());
		sc.nextLine();
		student.setNota1(sc.nextDouble());
		student.setNota2(sc.nextDouble());
		student.setNota3(sc.nextDouble());
		
		System.out.printf("FINAL GRADE = %.2f\n", student.calculateFinalGrade());
		student.isStudentApproved();
		
		sc.close();
	}

}
