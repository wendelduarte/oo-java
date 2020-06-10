package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date date;
	private Double totalValue;
	private List<Installment> installments = new ArrayList<Installment>();
	
	public Contract(Integer number, String date, Double totalValue, int numberOfInstallments) throws ParseException {
		this.number = number;
		this.date = sdf.parse(date);
		this.totalValue = totalValue;
		for(int i = 0; i<numberOfInstallments; i++) {
			addInstallments(new Installment());
		}
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDate() {
		return sdf.format(date);
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public List<Installment> getInstallments() {
		return installments;
	}
	public void addInstallments(Installment installment) {
		this.installments.add(installment);
	}
}
