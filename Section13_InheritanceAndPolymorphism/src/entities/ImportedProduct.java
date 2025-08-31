package entities;

public class ImportedProduct extends Product {

	private double customsFee;
	
	public ImportedProduct(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}

	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $ " 
		+ String.format("%.2f", totalPrice()) 
		+ " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
	}
	
}
