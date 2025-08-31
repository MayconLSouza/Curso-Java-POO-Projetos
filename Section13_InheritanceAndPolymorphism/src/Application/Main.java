package Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.printf("Product #%d data:", i);
            System.out.print("\nCommon, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            switch (ch) {
                case 'i':
                    System.out.print("Custom fee: ");
                    double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customsFee));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate manufactureDate = LocalDate.parse(sc.next(), formatter);
                    list.add(new UsedProduct(name, price, manufactureDate));
                    break;
                case 'c':
                    list.add(new Product(name, price));
                    break;
                default:
                    System.err.print("Type of product not recognized.");
                    break;
            }
        }

        System.out.println("\nPRICE TAGS");

        for(Product p : list){
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
