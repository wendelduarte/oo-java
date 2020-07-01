package exrciciosCursoJava.Interfaces.src.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import exrciciosCursoJava.Interfaces.src.entities.Contract;
import exrciciosCursoJava.Interfaces.src.entities.Installment;

public class ContractService {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private OnlinePaymentService onlinePayment;
	
	public ContractService(OnlinePaymentService onlinePayment) {
		this.onlinePayment = onlinePayment;
	}
	
	public void processInstallmentDate (Contract contract) throws ParseException {
		Date contractDate = sdf.parse(contract.getDate());
		int count = 1;
		for(Installment installment : contract.getInstallments()) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(contractDate);
			cal.add(Calendar.MONTH, count);
			installment.setDueDate(sdf.format(cal.getTime()));
			count++;
		}
	}
	
	public void processInstallmentAmount (Contract contract) {
		Double installmentAmount = contract.getTotalValue()/contract.getInstallments().size();
		int monthCount = 1;
		for(Installment installment : contract.getInstallments()) {
			Double amountWithFee = onlinePayment.paymentFee(onlinePayment.interest(installmentAmount, monthCount));
			installment.setAmount(amountWithFee);
			monthCount++;
		}
	}
	
}
