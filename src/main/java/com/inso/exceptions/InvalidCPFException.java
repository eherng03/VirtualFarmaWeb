package com.inso.exceptions;

public class InvalidCPFException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "CPF no válido.";
	}
}
