package entity;

public class Student {

	private String name;
	private double nota1;
	private double nota2;
	private double nota3;
	private double notaFinal;
	
	public Student() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		if(nota1 > 30.00 || nota1 < 0.00) {
			System.out.println("Nota Inválida!");
		} else {
			this.nota1 = nota1;
		}
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		if(nota2 > 35.00 || nota2 < 0.00) {
			System.out.println("Nota Inválida!");
		} else {
			this.nota2 = nota2;
		}
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		if(nota3 > 35.00 || nota3 < 0.00) {
			System.out.println("Nota Inválida!");
		} else {
			this.nota3 = nota3;
		}
	}
	
	public double calculateFinalGrade() {
		notaFinal = nota1 + nota2 + nota3; 
		return notaFinal;
	}
	
	public void isStudentApproved() {
		if(notaFinal >= 60.00) {
			System.out.println("PASS");
		} else {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS", 60.00 - notaFinal);
		}
	}
}
