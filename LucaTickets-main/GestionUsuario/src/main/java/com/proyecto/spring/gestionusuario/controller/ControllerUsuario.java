package com.proyecto.spring.gestionusuario.controller;

import java.util.Optional;
import javax.validation.Valid;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.proyecto.spring.gestionusuario.controller.error.UsuarioNotFoundException;
import com.proyecto.spring.gestionusuario.exception.CustomException;
import com.proyecto.spring.gestionusuario.exception.ExceptionUsuario;
import com.proyecto.spring.gestionusuario.model.Usuario;
import com.proyecto.spring.gestionusuario.service.ServiceUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "CRUD de usuarios")
@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

	@Autowired
	ServiceUsuario service;

	private static Logger log = LogManager.getLogger(ControllerUsuario.class);

	@ApiOperation(value = "Añade un nuevo usuario recibido en el cuerpo de la petición")
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario addUsuario(
			@ApiParam(value = "Objeto JSON a añadir", required = true) @Valid @RequestBody Usuario usuario,
			Errors errors) {
		log.info("------ addUsuario (POST) ");
		if (errors.hasErrors()) {
			throwError(errors);
		}
		return service.addUsuario(usuario);
	}

	@ApiOperation(value = "Devuelve la lista de usuarios existentes", response = List.class)
	@GetMapping()
	public List<Usuario> getAllUsuarios() {
		log.info("------ getAllUsuarios (GET) ");
		return service.getAllUsuarios();
	}

	@ApiOperation(value = "Actualiza en la base de datos el usuario recibido en el cuerpo de la petición")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editUsuario(
			@ApiParam(value = "Objeto JSON a actualizar", required = true) @RequestBody Usuario usuario,
			@PathVariable int id) {
		log.info("------ editUsuario (PUT) ");
		Usuario usuarioDB = service.findById(id).orElseThrow(UsuarioNotFoundException::new);
		usuarioDB.setLastname(usuario.getLastname());
		usuarioDB.setMail(usuario.getMail());
		usuarioDB.setName(usuario.getName());
		usuarioDB.setPassw(usuario.getPassw());
		return service.addUsuario(usuarioDB);
	}

	@GetMapping("find/{mail}")
	public Usuario findUserbyLogin(@PathVariable("mail") String mail) {
		log.info("------ findUserbyLogin (GET) ");
		return service.findByMail(mail).orElseThrow(UsuarioNotFoundException::new);
	}

	@ApiOperation(value = "Elimina el usuario a partir de su identificador")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Usuario deleteUsuario(@ApiParam(value = "Identificador", required = true) @PathVariable int id) {
		log.info("------ deleteUsuario (DELETE) ");
		return service.deleteById(id).orElseThrow(UsuarioNotFoundException::new);
	}

	@ApiOperation(value = "Localiza un usuario por su identificador", response = Usuario.class)
	@GetMapping("/{id}")
	public Usuario findUserbyId(@ApiParam(value = "Identificador", required = true) @PathVariable("id") int id) {
		log.info("------ findUserbyId (GET) ");
		return service.findById(id).orElseThrow(UsuarioNotFoundException::new);
	}

	public void throwError(Errors errors) {
		String message = "";
		int index = 0;
		for (ObjectError r : errors.getAllErrors()) {
			if (index > 0) {
				message += " | ";

			}
			message += String.format("Parametro: %s - Message: %s", r.getObjectName(), r.getDefaultMessage());
		}
		throw new CustomException(message);
	}

}
