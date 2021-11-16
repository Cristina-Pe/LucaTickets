package com.proyecto.spring.gestionevento.response;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

//DTO
public class EventoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private String shortDesc, longDesc;
	private Date date;
	private Time hora;
	private int priceMax, priceMin;
	private String protocols;
	private String genre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
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

}
