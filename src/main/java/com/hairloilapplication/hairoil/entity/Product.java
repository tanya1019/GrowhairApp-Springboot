package com.hairloilapplication.hairoil.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	String productName;
	Integer quantity;
	Double amount;
	String sellerName;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JsonIgnore
	Retailer retailer;
	
	

	public Product(Integer id, String productName, Integer quantity, Double amount, String sellerName,
			Retailer retailer) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.amount = amount;
		this.sellerName = sellerName;
		this.retailer = retailer;
	}

	public Product() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Retailer getRetailer() {
		return retailer;
	}
	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	
	
}
