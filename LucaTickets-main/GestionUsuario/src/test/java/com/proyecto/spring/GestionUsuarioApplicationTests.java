package com.proyecto.spring;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.proyecto.spring.gestionusuario.controller.ControllerUsuario;
import com.proyecto.spring.gestionusuario.model.Usuario;
import com.proyecto.spring.gestionusuario.repository.UsuarioDAO;
import com.proyecto.spring.gestionusuario.service.ServiceUsuario;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class GestionUsuarioApplicationTests {

	/**
	 * Comprueba si añade un usuario nuevo
	 */
	@Mock
	UsuarioDAO test;
	
	
	@Autowired
	MockMvc mock;
	
	@Autowired
	ControllerUsuario usuarioDao;
	

	ControllerUsuario controllerUsuario;
	
	@BeforeEach
	public void setup() {
		Usuario usuario=new Usuario();
		
		usuario.setName("Pepe");
		Mockito.when(test.save(usuario)).thenReturn(usuario);
	}
	/*
	@Test
	void testAñadirUsuario01() {
		Usuario usuario=new Usuario();
		usuario.setName("Pepe");
		Usuario usuario2=new Usuario();
		Assertions.assertThat(servicio.addUsuario(usuario2)).isEqualTo(usuario);
	}
	*/
	/*
	@Test
	void testAñadirUsuario03() {
		Usuario usuario = new Usuario();
		usuario.setName("nombre");
		usuario.setLastname("apellido");
		usuario.setPassw("password123");
		usuario.setMail("mail@");
		
		
		//assertEquals(usuarioDao.addUsuario(usuario).getName(), usuario.getName());
		
	}
	*/
	

}

