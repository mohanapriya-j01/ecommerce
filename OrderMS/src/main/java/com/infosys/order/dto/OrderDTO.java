package com.infosys.order.dto;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

	private Integer buyerId;
	private String address;
	private Integer orderId;
	private Long amount;
	private LocalDate date;
	private String status;
	private List orderedProducts;
	
	public List getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [buyerId=" + buyerId + ", address=" + address + ", orderId=" + orderId + ", amount=" + amount
				+ ", date=" + date + ", status=" + status + ", orderedProducts=" + orderedProducts + "]";
	}
	
}
