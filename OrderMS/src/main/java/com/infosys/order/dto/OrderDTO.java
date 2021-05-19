package com.infosys.order.dto;

public class OrderDTO {

	private Integer buyerId;
	private String address;
	
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
	@Override
	public String toString() {
		return "OrderDTO [buyerId=" + buyerId + ", address=" + address + "]";
	}
	
	
}
