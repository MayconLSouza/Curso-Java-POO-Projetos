package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.printf("Tax payer #%d data:", i);
            System.out.print("\nIndividual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Annual Income: ");
            double annualIncome = sc.nextDouble();

            if(ch == 'i'){
                System.out.print("Health costs: ");
                double healthCosts = sc.nextDouble();
                list.add(new Individual(name, annualIncome, healthCosts));
            } else if (ch == 'c') {
                System.out.print("Number of employees: ");
                int employeesNumbers = sc.nextInt();
                list.add(new Company(name, annualIncome, employeesNumbers));
            } else {
                System.err.println("Input invalid");
            }
        }

        System.out.print("\nTAXES PAID: ");
        double sum = 0.0;

        for(TaxPayer t : list){
            System.out.printf("\n%s: $ %.2f", t.getName(), t.calculateTax());
            sum += t.calculateTax();
        }

        System.out.println("\n\nTOTAL TAXES: $ " + String.format("%.2f", sum));
        sc.close();

    }
}
