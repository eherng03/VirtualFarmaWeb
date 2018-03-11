package com.inso.exceptions;

public class EmptyFieldException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Debe rellenar todos los campos con\nsus datos personales.";
	}
}
