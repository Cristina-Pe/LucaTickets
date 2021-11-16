package com.proyecto.spring.gestionusuario.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.spring.gestionusuario.security.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * @author Sebas 
	 * se permiten todas las llamadas al controlador /user, 
	 * pero el resto de las llamadas requieren autenticación.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated();
		
/*
 *              .antMatchers(HttpMethod.GET, "/user/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasRole("ADMIN")
 * 		
 */
	}
}
