package com.proyecto.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.spring.gestionusuario.controller.ControllerUsuario;
import com.proyecto.spring.gestionusuario.model.Usuario;
import com.proyecto.spring.gestionusuario.service.ServiceUsuario;

public class TestAssetj {

	@Autowired
	ControllerUsuario controlador;

	/**
	 * Comprueba que no se puede añadir usuario null
	 */
	/*
	 * @Test void testAñadirUsuario02() { Usuario usuario=new Usuario();
	 * Assertions.assertThat(controlador.addUsuario(usuario)).isNotNull(); }
	 */
}
