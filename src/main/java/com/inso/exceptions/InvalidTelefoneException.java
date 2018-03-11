package com.inso.exceptions;

public class InvalidTelefoneException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Teléfono no válido.";
	}
}
