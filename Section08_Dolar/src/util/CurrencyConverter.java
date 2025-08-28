package util;

public class CurrencyConverter {

	public static final double TAX_RATE = 0.06;
	
	public static double currencyExchange(double exchangeRate, double amount) {
		double reais = amount * exchangeRate;
		reais += reais * TAX_RATE;
		return reais;
	}
}
