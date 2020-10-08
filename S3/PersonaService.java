package com.restfulwebservices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.restfulwebservices.model.*;

public interface PersonaService {
	public abstract List<Persona> getPersonas();
	public abstract ResponseEntity<Object> getPersona(int id);
	public abstract ResponseEntity<Object> createPersona(Persona persona);
	public abstract void updatePersona(int id, Persona persona);
	public abstract void deletePersona(int id);
}
