package com.proyecto.spring.gestionevento.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.validation.Errors;
import com.proyecto.spring.gestionevento.model.Evento;

public interface EventoRepository extends MongoRepository<Evento, String> {
	
	@Query
	
	/**
	* Método que devuelve lista de eventos recibiendo genero
	*/

	List<Evento> findByGenre(String genre);
	
	/**
	* Método que devuelve lista de eventos recibiendo un nombre
	*/

	List<Evento> findByName(String name);
	List<Evento> findByCity(String city);
	
	
	public Optional<Evento> deleteByName(String name);

	@SuppressWarnings("unchecked")
	public Evento save(Evento evento);

	
	//public void throwError(Errors errors);
	
	
}
