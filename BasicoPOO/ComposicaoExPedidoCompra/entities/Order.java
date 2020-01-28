package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatusEnum;

public class Order {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatusEnum status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatusEnum status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatusEnum getStatus() {
		return status;
	}
	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}	
	
	private Double total() {
		Double totalOrder = 0.0;
		for (OrderItem item : items) {
			totalOrder += item.subTotal();
		}
		return totalOrder;
	}
	
	@Override
	public String toString() {
		StringBuilder strB = new StringBuilder();
		
		strB.append("Order Sumary\n");
		strB.append("Order Moment: ");
		strB.append(sdf.format(moment)+ "\n");
		strB.append("Order Status: " + status + "\n");
		strB.append("Client: " + client.getName() + "(" + client.getBirthDate() + ") ");
		strB.append("- " + client.getEmail() + "\n");
		strB.append("Order Items:\n");
		
		for(OrderItem item : items) {
			strB.append(item.getProduct().getName() + ", ");
			strB.append("$" + item.getProduct().getPrice() + ", ");
			strB.append("Subtotal: " + item.subTotal() + "\n");
		}
		
		strB.append("Total price: $" + total());
		
		return strB.toString();
	}
}
