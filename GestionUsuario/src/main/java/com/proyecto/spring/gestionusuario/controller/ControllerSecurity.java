package com.proyecto.spring.gestionusuario.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.proyecto.spring.gestionusuario.model.Usuario;
import com.proyecto.spring.gestionusuario.service.ServiceUsuario;
import com.proyecto.spring.gestionusuario.controller.error.UsuarioNotFoundException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ControllerSecurity {

	@Autowired
	ServiceUsuario service;

	@PostMapping("login")
	public String login(@RequestParam("mail") String mail, @RequestParam("password") String pwd) {

		if (service.findByMail(mail).orElseThrow(UsuarioNotFoundException::new) == service.findByPwd(pwd).orElseThrow(UsuarioNotFoundException::new)) {
			String token = getJWTToken(mail);
			Usuario user = new Usuario();
			user.setMail(mail);
			// No encriptado
			user.setPassw(pwd);
			user.setToken(token);
			return user.getToken();
		} else
			return null;

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
