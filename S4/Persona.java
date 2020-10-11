package com.restfulwebservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="Los apellidos de la persona deben tener al menos 2 letras")
	private String apellidos;
	
	@Past
	private Date fecha_nacimiento;
	
	@Size(min=2, message="El domicilio de la persona debe tener al menos 2 letras")
	private String domicilio;
	
	@Size(min=2, message="El rfc de la persona debe tener al menos 2 letras")
	private String rfc;
	
	@JoinColumn(name = "id_persona")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Tweet> tweets;
	
	public Persona() {
		
	}

	public Persona(Integer id,
			@Size(min = 2, message = "El nombre de la persona debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "Los apellidos de la persona deben tener al menos 2 letras") String apellidos,
			@Past Date fecha_nacimiento,
			@Size(min = 2, message = "El domicilio de la persona debe tener al menos 2 letras") String domicilio,
			@Size(min = 2, message = "El rfc de la persona debe tener al menos 2 letras") String rfc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.domicilio = domicilio;
		this.rfc = rfc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento="
				+ fecha_nacimiento + ", domicilio=" + domicilio + ", rfc=" + rfc + "]";
	}
	
	
}
