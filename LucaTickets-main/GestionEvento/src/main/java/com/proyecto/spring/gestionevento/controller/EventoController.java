package com.proyecto.spring.gestionevento.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.spring.gestionevento.controller.error.EventoNotFoundException;
import com.proyecto.spring.gestionevento.exception.CustomException;
import com.proyecto.spring.gestionevento.model.Evento;
import com.proyecto.spring.gestionevento.service.ServiceEventos;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	private static Logger log = LogManager.getLogger(EventoController.class);

	@Autowired
	ServiceEventos service;
	
	@GetMapping()
	public List<Evento> getAllEventos() {
		log.info("------ getAllEventos (GET) ");
		return service.getAllEventos();
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento addEvento(
			@ApiParam(value = "Objeto JSON a añadir", required = true) @Valid @RequestBody Evento evento,
			Errors errors) {	
		log.info("------ addEvento (POST) ");
		if (errors.hasErrors()) {
			throwError(errors);
		}
		return service.save(evento);
	}

	@GetMapping("/{name}")
	public Evento findByNameEvento(@PathVariable("name") String name) {
		log.info("------ findByNameEvento (GET) ");
		return service.findByNameEvento(name).get();
	}

	@DeleteMapping("/{name}")
	public Evento deleteEventoName(@PathVariable("name") String name) {
		log.info("------ deleteEventoName (DELETE) ");
		return service.deleteByName(name).orElseThrow(EventoNotFoundException::new);
	}

	@GetMapping("/list/genre/{genero}")
	public List<Evento> listaGeneros(@PathVariable("genero") String genre) {
		log.info("------ listaGeneros (GET) ");
		if (service.findByGenre(genre).isEmpty() != true)
			return service.findByGenre(genre);
		else
			throw new EventoNotFoundException();
	}

	@GetMapping("/list/name/{nombre}")
	public List<Evento> listaNombres(@PathVariable("nombre") String name) {
		log.info("------ listaNombres (GET) ");
		if (service.findByName(name).isEmpty() != true)
			return service.findByName(name);
		else
			throw new EventoNotFoundException();
	}
	
	@GetMapping("/list/city/{city}")
	public List<Evento> listaCiudades(@PathVariable("city") String city) {
		log.info("------ listaCiudades (GET) ");
		if (service.findByCity(city).isEmpty() != true)
			return service.findByCity(city);
		else
			throw new EventoNotFoundException();
	}

	@PutMapping()
	public Evento editEvento(@RequestBody Evento evento) {
		log.info("------ editEvento (PUT) ");
		return service.save(evento);
	}
	
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
