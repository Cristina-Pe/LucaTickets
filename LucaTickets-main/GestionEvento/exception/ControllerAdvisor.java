package com.proyecto.spring.gestionusuario.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler
	public ErrorMensaje customException(CustomException exception) {
		return new ErrorMensaje("CustomException", exception.getMessage());
	}
}
