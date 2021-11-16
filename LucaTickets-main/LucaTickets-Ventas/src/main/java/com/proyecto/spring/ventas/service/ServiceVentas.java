package com.proyecto.spring.ventas.service;

import com.proyecto.spring.ventas.model.Peticion;
import com.proyecto.spring.ventas.model.Respuesta;

import reactor.core.publisher.Mono;

public interface ServiceVentas {
	
	public Respuesta procesarCompra(Peticion peticion);

}
