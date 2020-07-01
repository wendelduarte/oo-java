package exrciciosCursoJava.UsandoAbstract.entities;

public class LegalEntity extends Person {
	
	private int employeeNumber;
	
	public LegalEntity () {
		super();
	}

	public LegalEntity(String name, Double annualIncome, int employeeNumber) {
		super(name, annualIncome);
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public double calcTax() {
		double valueTax = (employeeNumber < 10) ? 0.16 : 0.14;
		return super.getAnnualIncome() * valueTax;
	}
}
