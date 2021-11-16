package com.proyecto.spring.gestionusuario.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ExceptionUsuario {
	
	public void throwError(Errors errors) {
		String message = "";
		int index = 0;
		for (ObjectError r : errors.getAllErrors()) {
			if (index > 0) {
				message += " | ";

			}
			message += String.format("Parametro: %s - Message: %s", r.getObjectName(), r.getDefaultMessage());
		}
		throw new CustomException(message);
	}
	
}
