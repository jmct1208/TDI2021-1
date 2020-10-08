package com.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="El usuario debe tener al menos 2 caracteres")
	private String usuario;
	
	@Size(min=2, message="El password debe tener al menos 8 caracteres")
	private String password;
	
	private Integer tipo_usuaro;
	
	public Usuario() {
		
	}

	public Usuario(Integer id, @Size(min = 2, message = "El usuario debe tener al menos 2 caracteres") String usuario,
			@Size(min = 2, message = "El password debe tener al menos 8 caracteres") String password,
			Integer tipo_usuaro) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.tipo_usuaro = tipo_usuaro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTipo_usuaro() {
		return tipo_usuaro;
	}

	public void setTipo_usuaro(Integer tipo_usuaro) {
		this.tipo_usuaro = tipo_usuaro;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", tipo_usuaro=" + tipo_usuaro
				+ "]";
	}

}
