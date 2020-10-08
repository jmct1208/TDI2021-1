package com.restfulwebservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfulwebservices.service.PersonaService;
//import com.sun.el.stream.Optional;
import com.restfulwebservices.model.*;
import com.restfulwebservices.repository.PersonaRepository;

@RestController
public class PersonaCtrl {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/persona")
	public List<Persona> getPersonas(){
		return personaService.getPersonas();
	}
	
	@GetMapping("/persona/{id}/tweet")
	public List<Tweet> getTweetsPersona(@PathVariable int id){
		Optional<Persona> userOptional = personaRepository.findById(id);
		
		return userOptional.get().getTweets();
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity<Object> getPersona(@PathVariable int id){
		return personaService.getPersona(id);
	}
	
	@PostMapping("/persona")
	public ResponseEntity<Object> createPersona(@Valid @RequestBody Persona persona){
		ResponseEntity<Object> savedPersona = personaService.createPersona(persona);
		
		return null;
	}
	
	@PutMapping("/persona/{id}")
	public void updatePersona(@Valid @RequestBody Persona persona, @PathVariable int id) {
		personaService.updatePersona(id, persona);
	}
	
	@DeleteMapping("/persona/{id}")
	public void deletePersona(@PathVariable int id) {
		personaService.deletePersona(id);
	}
}
