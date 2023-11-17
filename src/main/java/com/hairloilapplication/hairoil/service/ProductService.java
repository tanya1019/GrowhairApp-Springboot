package com.hairloilapplication.hairoil.service;

import java.util.Collection;

import com.hairloilapplication.hairoil.entity.Product;
import com.hairloilapplication.hairoil.exception.ProductException;
import com.hairloilapplication.hairoil.exception.RetailerException;

public interface ProductService {

	Product addProductByRetailerId(Product newProduct , Integer retailerId) throws RetailerException;
	Collection<Product> getAllProducts();
	Product getProductByRetailerId(Integer productId, Integer retailerId) throws RetailerException, ProductException;
	Collection<Product> getProductsByRetailerId(Integer retailerId) throws RetailerException;
}
