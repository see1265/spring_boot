package com.jsp.college.sample.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.jsp.college.sample.helper.ResponseStructure;

@ControllerAdvice
public class ExceptionHandler {
 @org.springframework.web.bind.annotation.ExceptionHandler(UserDefinedException.class)//EH
	public ResponseEntity<ResponseStructure<String>> handlingException(UserDefinedException ue){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage(" ");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());    //respons entity is a  class, use= make it generic of the class
		responseStructure.setData(ue.getMessage());
		
	return new ResponseEntity<ResponseStructure<String>>(responseStructure, null, HttpStatus.BAD_REQUEST.value());
	}
}
