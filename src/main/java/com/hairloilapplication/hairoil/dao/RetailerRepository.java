package com.hairloilapplication.hairoil.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hairloilapplication.hairoil.entity.Retailer;

public interface RetailerRepository extends JpaRepository<Retailer, Integer> {

	Optional<Retailer> findByEmail(String email);
	List<Retailer> findByManagerId(Integer managerId);
}