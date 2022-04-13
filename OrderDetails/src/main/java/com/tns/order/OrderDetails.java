package com.tns.order;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderDetails 
{
	private Integer order_id;
	private LocalDateTime dateOfPurchase;
	private Float total;
	private String customer;
	
	public OrderDetails(Integer order_id, LocalDateTime dateOfPurchase, Float total, String customer) 
	{
		this.order_id = order_id;
		this.dateOfPurchase = dateOfPurchase;
		this.total = total;
		this.customer = customer;
	}

	public OrderDetails() {
	
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public LocalDateTime getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", dateOfPurchase=" + dateOfPurchase + ", total=" + total
				+ ", customer=" + customer + "]";
	}
	
}
