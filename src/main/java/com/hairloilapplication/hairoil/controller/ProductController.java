package com.hairloilapplication.hairoil.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hairloilapplication.hairoil.entity.Product;
import com.hairloilapplication.hairoil.exception.ProductException;
import com.hairloilapplication.hairoil.exception.RetailerException;
import com.hairloilapplication.hairoil.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;

	@PostMapping("product/{retailerId}")
	public Product addProductByRetailerId(@RequestBody Product newProduct,  @PathVariable("retailerId") Integer retailerId) throws RetailerException {
		return this.productService.addProductByRetailerId(newProduct, retailerId);
	}
	
	@GetMapping("/products")
	public Collection<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@GetMapping("/product/{productId}/{retailerId}")
	public Product getProductByRetailerId(@PathVariable("productId") Integer productId,@PathVariable("retailerId") Integer retailerId ) throws RetailerException, ProductException {
		return this.productService.getProductByRetailerId(productId, retailerId);
	}
	
	@GetMapping("products/{retailerId}")
	public Collection<Product> getProductsByRetailerId(@PathVariable("retailerId") Integer retailerId) throws RetailerException {
		return this.productService.getProductsByRetailerId(retailerId);
	}
	
}
