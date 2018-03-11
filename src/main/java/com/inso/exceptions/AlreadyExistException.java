package com.inso.exceptions;

public class AlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Los datos introducidos ya exiten.";
	}
}
