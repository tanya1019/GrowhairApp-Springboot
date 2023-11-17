package com.hairloilapplication.hairoil.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hairloilapplication.hairoil.exception.ProductException;
import com.hairloilapplication.hairoil.exception.RetailerException;
@RestControllerAdvice
public class AdviceException {

	@ExceptionHandler(RetailerException.class)
    public ResponseEntity<String> handleRetailerException(RetailerException retailerException ){
        return new ResponseEntity<String>(retailerException.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ProductException.class)
    public ResponseEntity<String> handleProductException(ProductException productException ){
        return new ResponseEntity<String>(productException.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
}
