package model.exceptions;

public class BalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BalanceException(String msg) {
		super(msg);
	}
}
