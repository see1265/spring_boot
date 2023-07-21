package com.jsp.college.sample.exceptionhandling;

public class UserDefinedException extends RuntimeException
{
private String message;
public UserDefinedException(String message)
{
	
	this.message=message;
}
public String getMessage(){
	return message;
   }

}
