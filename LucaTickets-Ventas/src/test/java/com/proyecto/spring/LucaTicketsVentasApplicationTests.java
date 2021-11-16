package com.proyecto.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import com.proyecto.spring.ventas.controller.VentrasController;
import com.proyecto.spring.ventas.model.Peticion;
import com.proyecto.spring.ventas.model.Respuesta;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
class LucaTicketsVentasApplicationTests {

	private static Logger log = LogManager.getLogger(VentrasController.class);

	@Autowired
	VentrasController ventasController;

	@Test

	@Order(0)
	public void procesarCompra() {
		log.info("Test01- Procesar una compra");
		BindingResult result = mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(false);
		Peticion peticion = new Peticion("5540500001000004", "666", "Cristina", "Camela", "Córdoba");
		Respuesta respuesta = new Respuesta("Purchase successfull");
		assertEquals(ventasController.procesarCompra(peticion, result), ResponseEntity.ok(respuesta));
	}

	@Test
	@Order(1)
	public void procesarCompraErronea() {
		log.info("Test02- Procesar una compra erronea");
		BindingResult result = mock(BindingResult.class);
		when(result.hasErrors()).thenReturn(true);
		Peticion peticion = new Peticion("4540500001000004", "666", "Cristina", "Camela", "Córdoba");
		Respuesta respuesta = new Respuesta("Purchase successfull");
		assertNotEquals(ventasController.procesarCompra(peticion, result), ResponseEntity.ok(respuesta));
	}

}
