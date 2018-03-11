package com.inso.exceptions;

public class IncorrectDNIException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "El DNI es incorrecto";
	}
}
