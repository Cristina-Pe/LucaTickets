package com.proyecto.spring.ventas.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peticion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@CreditCardNumber(ignoreNonDigitCharacters = true)
	@NotNull
	private String creditCard;
	@Size(min=3, max=3)
	@NotNull
	private String cvv;
	@Size(min=1)
	@NotNull
	private String creditCardOwner;
	@NotNull
	private String event;
	@NotNull
	private String city;

}
