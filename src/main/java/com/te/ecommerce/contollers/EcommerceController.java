package com.te.ecommerce.contollers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.ecommerce.bean.ItemResponse;
import com.te.ecommerce.exp.ItemException;

@RestControllerAdvice
public class EcommerceController {
	
	@ExceptionHandler(ItemException.class)
	public ItemResponse exceptionHandler(ItemException exception) {
		ItemResponse response = new ItemResponse();
		response.setStatusCode(500);
		response.setMessage(exception.getMessage());
		return response;
	}
}
