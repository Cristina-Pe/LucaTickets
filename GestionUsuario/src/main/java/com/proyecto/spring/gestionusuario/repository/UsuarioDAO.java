package com.proyecto.spring.gestionusuario.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import com.proyecto.spring.gestionusuario.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	/*
	 * Guardar nuevo usuario
	 */
	@SuppressWarnings("unchecked")
	public Usuario save(Usuario usuario);
	
	
	Optional<Usuario> findByMail(String name);
	
	Optional<Usuario> findByPassw(String name);
	
	//public void throwError(Errors errors);
}
