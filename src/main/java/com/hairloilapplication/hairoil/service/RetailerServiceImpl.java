package com.hairloilapplication.hairoil.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hairloilapplication.hairoil.dao.RetailerRepository;
import com.hairloilapplication.hairoil.entity.Retailer;
import com.hairloilapplication.hairoil.exception.RetailerException;

@Service
public class RetailerServiceImpl implements RetailerService {

	@Autowired
	RetailerRepository retailerRepo;
	
	@Override
	public Retailer addRetailer(Retailer newRetailer) throws RetailerException {
		Optional<Retailer> retailerOpt = this.retailerRepo.findByEmail(newRetailer.getEmail());
		if(retailerOpt.isPresent()) {
			throw new RetailerException("Retailer Already Exist");
		}
		else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			newRetailer.setPassword(passwordEncoder.encode(newRetailer.getPassword()));
			return this.retailerRepo.save(newRetailer);
		}	
	}

	@Override
	public Collection<Retailer> getAllRetailers(){
		return this.retailerRepo.findAll();
		}

	@Override
	public Retailer getRetailerById(Integer retailerId) throws RetailerException {
		
		Optional<Retailer> retailerOpt = this.retailerRepo.findById(retailerId);
		if(!retailerOpt.isPresent()) {
			throw new RetailerException("Retailer not found");
		}
		return retailerOpt.get();
	}

	@Override
	public List<Retailer> getRetailerByManagerId(Integer managerId) throws RetailerException {	
		return this.retailerRepo.findByManagerId(managerId);
	}

}
