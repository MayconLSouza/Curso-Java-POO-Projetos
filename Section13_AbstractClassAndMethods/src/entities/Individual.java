package entities;

public class Individual extends TaxPayer {

    private double healthCosts;

    public Individual(String name, double annualIncome, double healthCosts) {
        super(name, annualIncome);
        this.healthCosts = healthCosts;
    }

    public double getHealthCosts() {
        return healthCosts;
    }

    public void setHealthCosts(double healthCosts) {
        this.healthCosts = healthCosts;
    }

    @Override
    public double calculateTax() {
        if(getAnnualIncome() < 20000){
            if(healthCosts > 0){
                return (getAnnualIncome() * 0.15) - (healthCosts * 0.5);
            } else {
                return getAnnualIncome() * 0.15;
            }
        } else {
            if(healthCosts > 0){
                return (getAnnualIncome() * 0.25) - (healthCosts * 0.5);
            } else {
                return getAnnualIncome() * 0.25;
            }
        }
    }

}
