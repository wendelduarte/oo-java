package entities;

public class IndividualPerson extends Person {

	private Double healthSpendig;
	
	public IndividualPerson() {
		super();
	}

	public IndividualPerson(String name, Double annualIncome, Double healthSpendig) {
		super(name, annualIncome);
		this.healthSpendig = healthSpendig;
	}

	public Double getHealthSpendig() {
		return healthSpendig;
	}

	public void setHealthSpendig(Double healthSpendig) {
		this.healthSpendig = healthSpendig;
	}

	@Override
	public double calcTax() {
		double valueTax = (super.getAnnualIncome() < 20000) ? 0.15 : 0.25;
		double totalTax = super.getAnnualIncome() * valueTax;
		if (healthSpendig != null || healthSpendig > 0) {
			totalTax -= (healthSpendig*0.5);
		}
		return totalTax;
	}
}
