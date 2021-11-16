package com.proyecto.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.proyecto.spring.gestionevento.controller.EventoController;
import com.proyecto.spring.gestionevento.model.Evento;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class GestionEventoApplicationTests {

	private static Logger log = LogManager.getLogger(EventoController.class);

	@Autowired
	MockMvc mock;

	@Autowired
	EventoController eventoControl;

	@Test
	@Order(0)
	public void testEventoAdd() {

		log.info("Test01- Añadir evento a la lista");

		// Given

		// When
		Evento evento = new Evento("Camela", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
				"Córdoba");

		// Then

		assertEquals(eventoControl.addEvento(evento, null), evento);
	}

	@Test
	@Order(1)
	public void testEventoNotNull() {

		log.info("Test02- Comprueba que el evento no es nulo");

		// Given

		// When
		Evento evento = new Evento("Camela", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
				"Córdoba");

		// Then

		assertNotNull(evento, "El evento no es nulo");
	}

	// test para comprobar que se añade un evento a la lista//

	@Test
	@Order(2)
	public void testAddEventoLista() {

		log.info("Test03- Comprueba que el tamaño de la lista de eventos no es igual tras añadir uno");

		// Given

		// When
		Evento evento = new Evento("Camela", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
				"Córdoba");

		// Then
		int tamanio = eventoControl.getAllEventos().size();

		eventoControl.addEvento(evento, null);
		int tamanio_2 = eventoControl.getAllEventos().size();

		assertNotEquals(tamanio, tamanio_2);
	}

	// test para probar el género electronica//

	@Test
	@Order(3)
	void testGeneros01() throws Exception {
		log.info("Test03- Obtener listado de eventos del género eletrónica");
		mock.perform(get("/eventos/list/genre/electronica")).andDo(print()).andExpect(status().isOk());
	}

	// test para probar el nombre Tomorrowland//

	@Test
	@Order(4)
	void testNombre01() throws Exception {
		log.info("Test05- Obtener listado de eventos con el nombre Tomorrowland");
		mock.perform(get("/eventos/list/name/Tomorrowland")).andDo(print()).andExpect(status().isOk());
	}

	// test para probar el nombre Tomorrowland//

	@Test
	@Order(5)
	void testAllEventos() throws Exception {
		log.info("Test06- Obtener listado de todos los eventos");
		mock.perform(get("/eventos")).andDo(print()).andExpect(status().isOk());
	}


	@Test
	@Order(6)
	public void testEventoDelete() {

		log.info("Test07- Eliminar un evento de la lista");

		// Given

		// When
		Evento evento = new Evento("Niña Pastori", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
				"Cádiz");

		// Then

		eventoControl.addEvento(evento, null);
		int tamanio = eventoControl.getAllEventos().size();
		eventoControl.deleteEventoName("Niña Pastori");
		int tamanio_2=eventoControl.getAllEventos().size();

		assertNotEquals(tamanio, tamanio_2);
	}


	
	
	@Test
	@Order(7)
	public void testEditarEvento() {

		log.info("Test08- Comprueba que se puede editar el evento");

		// Given
		Evento evento = new Evento("Camela", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
				"Córdoba");
		
		// When
		//Evento evento2 = new Evento("La Raíz", "Divertido", "Muyyy divertido", "22", "21", 36, 15, "ni idea", "Feria",
		//		"Córdoba");
		
		Evento evento2=evento;
		eventoControl.addEvento(evento2, null);
		evento2.setName("La Raíz");
		
		// Then

		
		assertEquals(eventoControl.editEvento(evento2).getName(), evento2.getName());
		
	}
	

}
