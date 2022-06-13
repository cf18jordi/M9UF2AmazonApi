package com.example.demo.models;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="presencias")
public class Presencia {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
 
	@Column(name="name", nullable=false, length=30)
	private String name;
 
	@Column(name="latitud",nullable=false)
	private double latitud;
 
	@Column(name="longitud", nullable=false)
	private double longitud;
 
	@Column(name="comentario", nullable=false, length=50)
	private String comentario;
	
	@Column(name="fecha", nullable=false, length=50)
	private String fecha;
	
	
 
	public Presencia() {
	}	
	public Presencia(String name, double latitud, double longitud) {
		this.name = name;
		this.latitud=latitud;
		this.longitud=longitud;
		this.comentario = "Bondia";
		this.fecha = "13/06/2022";
	}	
 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
 
}
