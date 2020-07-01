package exrciciosCursoJava.Interfaces.src.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDate;
	private Double amount;
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) throws ParseException {
		this.dueDate = sdf.parse(dueDate);
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}	
}
