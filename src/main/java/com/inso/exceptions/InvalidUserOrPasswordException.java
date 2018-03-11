package com.inso.exceptions;

public class InvalidUserOrPasswordException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Usuario o contraseña incorrectos.";
	}
}
