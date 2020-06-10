package service;

public class PaypalService implements OnlinePaymentService  {

	private static final double MONTHLY_INTEREST = 0.01;
	private static final double FEE_PERCENTAGE = 0.02;
	
	public Double interest(Double amount, int month) {
		return amount + amount*MONTHLY_INTEREST * month;
	}
	
	public Double paymentFee(Double amount) {
		return amount + amount*FEE_PERCENTAGE;
	}
}
