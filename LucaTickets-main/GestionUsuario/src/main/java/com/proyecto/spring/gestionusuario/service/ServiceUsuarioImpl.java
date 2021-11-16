package com.proyecto.spring.gestionusuario.service;


import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import com.proyecto.spring.gestionusuario.exception.CustomException;
import com.proyecto.spring.gestionusuario.model.Usuario;
import com.proyecto.spring.gestionusuario.repository.UsuarioDAO;

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(int id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	public Optional<Usuario> findByMail(String mail) {
		return usuarioDao.findByMail(mail);
	}
	
	@Override
	public Optional<Usuario> findByPwd(String password) {
		return usuarioDao.findByPassw(password);
	}

	@Override
	public Optional<Usuario> deleteById(int id) {
		Optional<Usuario> deletedUser = usuarioDao.findById(id);
		usuarioDao.deleteById(id);
		return deletedUser;
		
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}
	
	
	/*
	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}
	*/

}
