package com.proyecto.spring.gestionusuario.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
@ApiModel(description = "Clase que encapsula los datos de un usuario")
@Entity
@Table(name="Usuario", schema = "public")
public class Usuario {

	private String token;
	@Email
	String mail;
	
	@NotEmpty(message="La contraseña no puede estar vacía!")
	String passw;
	
	@NotEmpty(message="El nombre no puede estar vacío!")
	String name;
	
	@NotEmpty(message="El apellido no puede estar vacío!")
	String lastname;
	
	float balance = 200;
	Date joinDate = new Date();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int UserNumber;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Usuario(String mail, String passw, String name, float balance, String lastname, Date joinDate,
			int userNumber) {
		super();
		this.mail = mail;
		this.passw = passw;
		this.name = name;
		this.balance = balance;
		this.lastname = lastname;
		this.joinDate = joinDate;
		UserNumber = userNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public int getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(int userNumber) {
		UserNumber = userNumber;
	}


	public float getBalance() {
		return balance;
	}

	public void setBalance(float Balance) {
		balance = Balance;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
