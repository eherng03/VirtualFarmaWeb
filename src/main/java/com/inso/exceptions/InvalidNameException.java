package com.inso.exceptions;

public class InvalidNameException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Nombre no válido.";
	}
}
