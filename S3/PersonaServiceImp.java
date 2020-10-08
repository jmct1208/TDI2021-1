package com.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restfulwebservices.model.Persona;
import com.restfulwebservices.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService{

	@Autowired
	private PersonaRepository repoPersona;
	
	public List<Persona> getPersonas(){
		return repoPersona.findAll();
	}
	
	public ResponseEntity<Object> getPersona(int id){
		return new ResponseEntity<>(repoPersona.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> createPersona(Persona persona){
		return new ResponseEntity<>(repoPersona.save(persona), HttpStatus.OK);
	}
	
	public void updatePersona(int id, Persona persona) {
		repoPersona.save(persona);
	}
	
	public void deletePersona(int id) {
		repoPersona.deleteById(id);
	}
}
