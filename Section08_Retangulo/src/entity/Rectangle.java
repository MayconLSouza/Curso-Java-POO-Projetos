package entity;

public class Rectangle {
	
	private double width;
	private double height;

	public Rectangle() {
		super();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double calculateArea() {
		return width * height;
	}
	
	public double calculatePerimeter() {
		return (width * 2) + (height * 2);
	}
	
	public double calculateDiagonal() {
		return Math.sqrt((Math.pow(width, 2)) + (Math.pow(height, 2)));
	}
}
