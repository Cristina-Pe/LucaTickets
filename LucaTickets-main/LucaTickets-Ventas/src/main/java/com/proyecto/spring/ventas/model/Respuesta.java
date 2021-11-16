package com.proyecto.spring.ventas.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;

	private String status;
	
	

}
