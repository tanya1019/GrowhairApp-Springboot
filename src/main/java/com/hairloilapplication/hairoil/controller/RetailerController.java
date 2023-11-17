package com.hairloilapplication.hairoil.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hairloilapplication.hairoil.entity.Retailer;
import com.hairloilapplication.hairoil.exception.RetailerException;
import com.hairloilapplication.hairoil.service.RetailerService;

@RestController
public class RetailerController {

	@Autowired
	RetailerService retailerService;
	
	@PostMapping("/retailer")
	public Retailer addRetailer(@RequestBody Retailer newRetailer) throws RetailerException {
		try {
			return this.retailerService.addRetailer(newRetailer);
		}
		catch (RetailerException e) {
			throw e;
		}
	}
	
	
	@GetMapping("/retailers")
	public Collection<Retailer> getAllRetailers() throws RetailerException {
		return this.retailerService.getAllRetailers();
	}
	
	
	@GetMapping("/retailer/{retailerId}")
	public Retailer getRetailerById(@PathVariable("retailerId") Integer retailerId) throws RetailerException {
		try {
			return this.retailerService.getRetailerById(retailerId);
		}
		catch(RetailerException e) {
			throw e;
		}
	}
	
	@GetMapping("/retailers/{managerId}")
	public List<Retailer> getRetailerByManagerName(@PathVariable("managerId") Integer managerId) throws RetailerException {
		try {
			return this.retailerService.getRetailerByManagerId(managerId);
		}
		catch(RetailerException e) {
			throw e;
		}
	}
	
		
		
	
}
