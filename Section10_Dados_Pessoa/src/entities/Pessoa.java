package entities;

public class Pessoa {

	private double altura;
	private char genero;
	
	public Pessoa(double altura, char genero) {
		this.altura = altura;
		this.genero = genero;
	}
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	
}
