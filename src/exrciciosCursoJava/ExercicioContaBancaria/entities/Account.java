package exrciciosCursoJava.ExercicioContaBancaria.entities;

public class Account {

	private int number;
	private String name;
	private double balance;
	
	public Account(int number, String name, double initialDeposit) {
		this.number = number;
		this.name = name;
		this.balance  += initialDeposit;
	}
	
	public Account(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public Account(int number, double balance) {
		this.number = number;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}	
	
	public void addBalance(double value) {
		balance += value;
	}
	
	public boolean hasLimit(double value) {
		if(balance - value - 5 < -500) {
			return false;
		}
		return true;
	}
	
	public boolean withdrawValue(double value) {
		double aux = value + 5;
		if(hasLimit(value)) {
			balance -= aux;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Account " + number + ", Holder: " + name + ", Balance: $" + balance;
	}
}
