package com.proyecto.spring.gestionevento.service;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyecto.spring.gestionevento.controller.error.EventoNotFoundException;
import com.proyecto.spring.gestionevento.exception.CustomException;
import com.proyecto.spring.gestionevento.model.Evento;
import com.proyecto.spring.gestionevento.model.Respuesta;
import com.proyecto.spring.gestionevento.repository.EventoRepository;

import reactor.core.publisher.Mono;


@Service
public class ServiceEventosImpl implements ServiceEventos {

	@Autowired
	EventoRepository eventoRepository;

	/**
	 * @author Cristina 
	 * Método que devuelve lista de eventos recibiendo el genero
	 * @param genre
	 * @return Lista de eventos
	 */

	@Override
	public List<Evento> findByGenre(String genre) {
		return eventoRepository.findByGenre(genre);
	}

	/**
	 * @author Cristina 
	 * Método que devuelve lista de eventos recibiendo el nombre
	 * @param name
	 * @return Lista de eventos
	 */

	@Override
	public List<Evento> findByName(String name) {
		
		return eventoRepository.findByName(name);

	}
	
	public List<Evento> findByCity(String city){
		
		return eventoRepository.findByCity(city);
	}
	
	
	/**
	 * @author Paula 
	 * Método que devuelve lista de todos los eventos
	 * @return Lista de eventos
	 */
	
	public List<Evento> getAllEventos(){
		return eventoRepository.findAll();
	}
	
	
	
	@Transactional
	public Evento save(Evento evento) {
		// TODO Auto-generated method stub
		return eventoRepository.save(evento);
	}
	
	/**
	 * @author Cristina 
	 * Método que devuelve el id un evento
	 * @return Lista de eventos
	 */
	
	@Override
	public Optional<Evento> findByNameEvento(String name) {
		
		if(!eventoRepository.findByName(name).isEmpty()) {
			Optional<Evento> nombreEvento = Optional.of(eventoRepository.findByName(name).get(0));
			return nombreEvento;
		}else {
			throw new EventoNotFoundException();
			
		}
		
	}
	
	@Override
	public Optional<Evento> findByCityEvento(String city) {
		// TODO Auto-generated method stub
		if(!eventoRepository.findByCity(city).isEmpty()) {
			Optional<Evento> nombreCity = Optional.of(eventoRepository.findByCity(city).get(0));
			return nombreCity;
		}else {
			throw new EventoNotFoundException();
		}
	}
	
	
	
	/**
	 * @author Cristina 
	 * Método que elimina un evento
	 * @return Lista de eventos
	 */


	public Optional<Evento> deleteByName(String name) {

		return eventoRepository.deleteByName(name);
		
	}

	
	public Respuesta getJWToken(String mail, String password) {
		
		JSONObject json = new JSONObject();
		json.put("mail", mail);
		json.put("password", password);
		
		WebClient client = WebClient.create();
		Mono<Respuesta> entityMono = client.post().
				uri("http://localhost:7777/login")
				.attribute("mail", mail)
				.attribute("password", password)
			    .retrieve()
			    .bodyToMono(Respuesta.class);
		
		Respuesta respuesta = new Respuesta();
		respuesta.setStatus(entityMono.toString());
		return respuesta;
	}
}
