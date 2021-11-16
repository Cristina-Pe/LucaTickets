package com.proyecto.spring.gestionevento.controller.error;

public class EventoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EventoNotFoundException() {
		super("Epic Fail: No existe el Evento");
	}
	public EventoNotFoundException(Long id) {
		super("Epic Fail: No existe el Evento "+id);
	}	

}
