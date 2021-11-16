package com.proyecto.spring.ventas.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyecto.spring.ventas.model.Peticion;
import com.proyecto.spring.ventas.model.Respuesta;

import reactor.core.publisher.Mono;

@Service
public class ServiceVentasImpl implements ServiceVentas {

	@SuppressWarnings("unchecked")
	@Override
	public Respuesta procesarCompra(Peticion peticion) {

		JSONObject json = new JSONObject();
		/*
		 * { 
		 * "creditCard": "string", 
		 * "creditCardOwner": "string", 
		 * "cvv": "string" 
		 * }
		 */
		json.put("creditCard", peticion.getCreditCard().toString());
		json.put("creditCardOwner", peticion.getCreditCardOwner().toString());
		json.put("cvv", peticion.getCvv().toString());
		
		WebClient client = WebClient.create();
		Mono<Respuesta> entityMono = client.post().
				uri("http://localhost:8050/")
				.body(Mono.just(json), Respuesta.class)
			    .retrieve()
			    .bodyToMono(Respuesta.class);
		
		return entityMono.block();
	}

}
