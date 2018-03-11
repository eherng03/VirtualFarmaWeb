package com.inso.exceptions;

public class InvalidSSNumberException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "El número de la Seguridad Social es incorrecto";
	}

}
