package entities;

public class Company extends TaxPayer {

    private int employeesNumbers;

    public Company(String name, double annualIncome, int employeesNumbers) {
        super(name, annualIncome);
        this.employeesNumbers = employeesNumbers;
    }

    public int getEmployeesNumbers() {
        return employeesNumbers;
    }

    public void setEmployeesNumbers(int employeesNumbers) {
        this.employeesNumbers = employeesNumbers;
    }
    
    @Override
    public double calculateTax() {
        if(employeesNumbers > 10) {
            return getAnnualIncome() * 0.14; 
        } else {
            return getAnnualIncome() * 0.16;
        }
    }
    
}
