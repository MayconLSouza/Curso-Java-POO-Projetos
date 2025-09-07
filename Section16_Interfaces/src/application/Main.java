package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data:");
        System.out.print("Number: ");
        int contractNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Contract Value: ");
        double contractValue = sc.nextDouble();
        Contract contract = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Enter the number of installments: ");
        int installmentNumber = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.proccessContract(contract, installmentNumber);

        System.out.println("Installments:");
        for(Installment i : contract.getInstallments()){
            System.out.println(i.toString());
        }

        sc.close();
    }
}
