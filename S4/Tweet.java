package com.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer id_persona;
	
	@NotEmpty(message="La descripción del tweet es obligatoria")
	private String descripcion;
	
	private String imagen;
	
	private String estatus;
	
	public Tweet() {
		
	}

	public Tweet(Integer id, Integer id_persona,
			@NotEmpty(message = "La descripción del tweet es obligatoria") String descripcion, String imagen,
			String estatus) {
		super();
		this.id = id;
		this.id_persona = id_persona;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.estatus = estatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", id_persona=" + id_persona + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", estatus=" + estatus + "]";
	}
}
