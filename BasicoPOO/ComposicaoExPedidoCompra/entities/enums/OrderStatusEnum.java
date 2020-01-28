package entities.enums;

public enum OrderStatusEnum {

	PENDING_PAYMENT(0),
	PROCESSING(1),
	SHIPPED(2),
	DELIVERED(3);
	
	private int value;
	
	OrderStatusEnum(int valueOption){
		value = valueOption;
	}
}
