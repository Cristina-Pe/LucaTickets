package com.proyecto.spring.gestionevento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.Errors;

import com.proyecto.spring.gestionevento.model.Evento;
import com.proyecto.spring.gestionevento.model.Respuesta;


public interface ServiceEventos {
	
	/**
	 * Metodo para listar por género
	 */
	public List<Evento> findByGenre(String genre);
	
	/**
	 * Metodo para listar por nombre
	 */
	
	public List<Evento> findByName(String name);
	public List<Evento> findByCity(String city);
	
	
	/**
	 * Método coger todos los eventos
	 */
	public List<Evento> getAllEventos();
	
	
	/**
	 * Método para guardar un evento
	 */
	
	public Evento save(Evento evento);
	

	/**
	 * @author Cristina 
	 * Método que elimina un evento
	 * @return Lista de eventos
	 */
	public Optional<Evento> deleteByName(String name);

	/**
	 * @author Cristina 
	 * Método que devuelve el id un evento
	 * @return Lista de eventos
	 */
	public Optional<Evento> findByNameEvento (String name);
	public Optional<Evento> findByCityEvento (String city);

	
	//public void throwError(Errors errors);
	
	public Respuesta getJWToken(String mail, String password);
	
}
