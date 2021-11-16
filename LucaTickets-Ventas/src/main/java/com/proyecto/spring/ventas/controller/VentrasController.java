package com.proyecto.spring.ventas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.ventas.model.Peticion;
import com.proyecto.spring.ventas.model.Respuesta;
import com.proyecto.spring.ventas.service.ServiceVentas;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class VentrasController {
	
	@Autowired
	ServiceVentas service;
	
	@PostMapping("/purchase")
	public ResponseEntity<Respuesta> procesarCompra(@Valid @RequestBody Peticion peticion, BindingResult result){
		log.info("Procesando compra: {}", peticion);
		
		Respuesta respuesta = new Respuesta();
		
		if(result.hasErrors()) {
			if(peticion.getCreditCard() == null) 
				respuesta.setStatus("Credit card must be not null");
			else if(peticion.getCreditCardOwner() == null) 
				respuesta.setStatus("Credit card owner must be not null");
			else if(peticion.getCvv() == null) 
				respuesta.setStatus("Cvv must be not null");
			else if(peticion.getCity() == null) 
				respuesta.setStatus("City must be not null");
			else if(peticion.getEvent() == null) 
				respuesta.setStatus("Event must be not null");
			else respuesta.setStatus("Format not valid");
			return ResponseEntity.badRequest().body(respuesta);
		}
		respuesta = service.procesarCompra(peticion);
		
		if(respuesta.getStatus().equals("Valid account")) {
			respuesta.setStatus("Purchase successfull");
			return ResponseEntity.ok(respuesta);
		}else {
			respuesta.setStatus("Error during the purchase: " + respuesta.getStatus());
			return ResponseEntity.badRequest().body(respuesta);
		}
		
		//return ResponseEntity.ok(respuesta);
	}

}
