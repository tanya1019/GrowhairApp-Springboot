package com.hairloilapplication.hairoil.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Retailer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String password;
	String contactNumber;
	String email;
	String name;
	Integer managerId;
	
	@OneToMany(cascade = {CascadeType.ALL})
	List<Product> products = new ArrayList<>();
	
	public Retailer() {
		super();
	}


	public Retailer(Integer id, String password, String contactNumber, String email, String name, Integer managerId,
			List<Product> products) {
		super();
		this.id = id;
		this.password = password;
		this.contactNumber = contactNumber;
		this.email = email;
		this.name = name;
		this.managerId = managerId;
		this.products = products;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	
}
