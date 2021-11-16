package com.proyecto.spring.gestionevento.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.proyecto.spring.gestionevento.model.Respuesta;
import com.proyecto.spring.gestionevento.service.ServiceEventos;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ControllerSecurity {

	@Autowired
	ServiceEventos service;

	@PostMapping("login")
	public ResponseEntity<Respuesta> login(@RequestParam("mail") String mail, @RequestParam("password") String pwd) {
		
		return ResponseEntity.ok(service.getJWToken(mail,pwd));

	}
}
