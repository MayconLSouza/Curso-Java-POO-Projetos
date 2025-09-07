package service;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void proccessContract(Contract contract, int months) {
        
        double basicInstallmentValue = contract.getTotalValue() / months;
        double interest = 0.0, fee = 0.0, installmentValue = 0.0;

        for(int i = 1; i <= months; i++) {
            LocalDate installmentDate = contract.getDate().plusMonths(i);

            interest = onlinePaymentService.interest(basicInstallmentValue, i);
            fee = onlinePaymentService.paymentFee(basicInstallmentValue + interest);
            installmentValue = basicInstallmentValue + interest + fee;

            contract.getInstallments().add(new Installment(installmentDate, installmentValue));
        }

    }

}
