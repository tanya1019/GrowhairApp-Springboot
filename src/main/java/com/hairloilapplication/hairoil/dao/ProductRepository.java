package com.hairloilapplication.hairoil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hairloilapplication.hairoil.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
