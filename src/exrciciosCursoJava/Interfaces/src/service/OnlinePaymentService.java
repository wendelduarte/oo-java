package exrciciosCursoJava.Interfaces.src.service;

public interface OnlinePaymentService {

	Double interest(Double amount, int month);
	Double paymentFee(Double amount);
}
