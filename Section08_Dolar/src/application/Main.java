package application;

import java.util.Scanner;

import util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double exchangeRate, amount;
		
		System.out.print("What is the dollar price? ");
		exchangeRate = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		amount = sc.nextDouble();
		System.out.printf("Amount to be paid in reais = %.2f", CurrencyConverter.currencyExchange(exchangeRate, amount));
		sc.close();
	}

}
