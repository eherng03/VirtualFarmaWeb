package com.inso.exceptions;

public class IncorrectPasswordException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "La contraseña solo puede contener\ncaracteres alfanuméricos, con un máximo\nde 20 dígitos";
	}
}
