package exrciciosCursoJava.Exceptions.model.entities;

import exrciciosCursoJava.Exceptions.model.exceptions.BalanceException;
import exrciciosCursoJava.Exceptions.model.exceptions.WithdrawLimitException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account (Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) {		
		if(amount > this.withdrawLimit)
			throw new WithdrawLimitException("The amount exceeds withdraw limit");
		
		if(this.balance < amount)
			throw new BalanceException("Not enough balance");
		
		this.balance -= amount;
	}
	
}
