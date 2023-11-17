package com.hairloilapplication.hairoil.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hairloilapplication.hairoil.dao.ProductRepository;
import com.hairloilapplication.hairoil.dao.RetailerRepository;
import com.hairloilapplication.hairoil.entity.Product;
import com.hairloilapplication.hairoil.entity.Retailer;
import com.hairloilapplication.hairoil.exception.ProductException;
import com.hairloilapplication.hairoil.exception.RetailerException;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	RetailerRepository retailerRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Product addProductByRetailerId(Product newProduct, Integer retailerId) throws RetailerException {
		Optional<Retailer> retailerOpt = this.retailerRepo.findById(retailerId);
		if(!retailerOpt.isPresent()) {
			throw new RetailerException("There is no retailer with id -->" + retailerId);
		}
		Retailer retailer = retailerOpt.get();
		newProduct.setRetailer(retailer);
		Product product = this.productRepo.save(newProduct);
		retailer.getProducts().add(product);
		this.retailerRepo.save(retailer);
		return product;
	}

	@Override
	public Collection<Product> getAllProducts() {
		return this.productRepo.findAll();	
	}

	@Override
	public Product getProductByRetailerId(Integer productId, Integer retailerId) throws RetailerException, ProductException {
		
		Optional<Retailer> retailerOpt = this.retailerRepo.findById(retailerId);
		if(!retailerOpt.isPresent()) {
			throw new RetailerException("There is no retailer with --> " + retailerId);
		}
		Retailer retailer = retailerOpt.get();
		
		Optional<Product> productOpt = this.productRepo.findById(productId);
		if(!productOpt.isPresent()) {
			throw new ProductException("There is no product with id -->" + productId);
		}
		Product product = productOpt.get();
		
		if(retailer.getProducts().contains(product)) {
			return product;
		}
		else {
			throw new ProductException("Product not present");
		}
	}

	@Override
	public Collection<Product> getProductsByRetailerId(Integer retailerId) throws RetailerException {
		
		Optional<Retailer> retailerOpt = this.retailerRepo.findById(retailerId);
		if(!retailerOpt.isPresent()) {
			throw new RetailerException("There is no retailer with id --> " + retailerId);
		}
		Retailer retailer = retailerOpt.get();
		
		Collection<Product> products = retailer.getProducts();
		return products;
	}

	
	
}
