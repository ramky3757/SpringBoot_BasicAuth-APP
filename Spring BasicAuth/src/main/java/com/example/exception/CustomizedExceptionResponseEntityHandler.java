package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice //this is to share controllerinfo across all controllers	
@RestController
public class CustomizedExceptionResponseEntityHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class) // This will be applied to all the exception classes
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception{
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	

}
