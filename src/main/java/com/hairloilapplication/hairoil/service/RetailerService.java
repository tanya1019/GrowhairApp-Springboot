package com.hairloilapplication.hairoil.service;

import java.util.Collection;
import java.util.List;

import com.hairloilapplication.hairoil.entity.Retailer;
import com.hairloilapplication.hairoil.exception.RetailerException;

public interface RetailerService {

	Retailer addRetailer(Retailer newRetailer) throws RetailerException;
	Collection<Retailer> getAllRetailers();
	Retailer getRetailerById(Integer retailerId) throws RetailerException;
	List<Retailer> getRetailerByManagerId(Integer managerId) throws RetailerException;
}
