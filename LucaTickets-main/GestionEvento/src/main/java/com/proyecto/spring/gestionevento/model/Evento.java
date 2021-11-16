package com.proyecto.spring.gestionevento.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Clase que encapsula los datos de un evento")
@Document(collection = "Evento")
public class Evento {

	@NotEmpty(message="El nombre no puede estar vacío!")
	private String name;
	private String shortDesc, longDesc;
	
	@NotEmpty(message="La fecha no puede estar vacía!")
	private String date;
	@NotEmpty(message="La hora no puede estar vacía!")
	
	
	private String hora;
	private int priceMax, priceMin;
	private String protocols;
	
	
	private String genre;
	
	@NotEmpty(message="La ciudad no puede estar vacía!")
	private String city;
	
	public Evento() {
		super();
	}

	public Evento(String name, String shortDesc, String longDesc, String date, String hora, int priceMax,
			int priceMin, String protocols, String genre, String city) {
		super();
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.date = date;
		this.hora = hora;
		this.priceMax = priceMax;
		this.priceMin = priceMin;
		this.protocols = protocols;
		this.genre = genre;
		this.city = city;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}

	public int getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}

	public String getProtocols() {
		return protocols;
	}

	public void setProtocols(String protocols) {
		this.protocols = protocols;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evento [name=");
		builder.append(name);
		builder.append(", shortDesc=");
		builder.append(shortDesc);
		builder.append(", longDesc=");
		builder.append(longDesc);
		builder.append(", date=");
		builder.append(date);
		builder.append(", hora=");
		builder.append(hora);
		builder.append(", priceMax=");
		builder.append(priceMax);
		builder.append(", priceMin=");
		builder.append(priceMin);
		builder.append(", protocols=");
		builder.append(protocols);
		builder.append(", genre=");
		builder.append(genre);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
}
