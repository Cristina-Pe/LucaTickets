package com.proyecto.spring.gestionusuario.service;


import java.util.List;
import java.util.Optional;

import org.springframework.validation.Errors;

import com.proyecto.spring.gestionusuario.model.Usuario;

public interface ServiceUsuario {
	
	/**
	 * Metodo para guardar usuario
	 */
	public Usuario addUsuario(Usuario usuario);
	
	/**
	 * Metodo para buscar usuario por id
	 */
	/*
	public Optional<Usuario> findById(int id);
	
	public Usuario findByMail(String mail);
	
	public Usuario findByPwd(String password);
	
	public Optional<Usuario> deleteById(int id);
	*/
	
	/**
	 * Metodo para buscar usuario por id
	 */
	public Optional<Usuario> findById(int id);
	
	/**
	 * Listar todos los usuarios
	 */
	public List<Usuario> findAll();
	
	/**
	 * Eliminar usuario por id
	 */
	public Optional<Usuario> deleteById(int id);
	
	/**
	 * Mostrar todos los usuarios
	 */
	public List<Usuario> getAllUsuarios();
	
	/**
	 * @author Sebas 
	 * Método que devuelve un usuario con la contraseña pasada
	 * @return usario con contraseña
	 */
	public Optional<Usuario> findByPwd(String password);
	
	/**
	 * @author Sebas 
	 * Método que devuelve un usuario con el mail pasado
	 * @return usario con mail
	 */
	public Optional<Usuario> findByMail(String mail);
	
	//public void throwError(Errors errors);
}
