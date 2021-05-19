package com.infosys.order.entity;

import java.io.Serializable;



public class ProductsOrderedId implements Serializable{
	private Integer buyerId;
	private Integer prodId;
	public Integer getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	
}
