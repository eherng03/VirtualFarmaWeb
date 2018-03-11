package com.inso.exceptions;

public class InvalidDNIException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "El DNI es incorrecto";
	}
}
