package com.restfulwebservices.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfulwebservices.model.Tweet;
import com.restfulwebservices.service.TweetService;

@RestController
public class TweetCtrl {

	@Autowired
	private TweetService tsrv;
	
	@GetMapping("/tweet")
	public ResponseEntity<Object> getTweets(){
		return new ResponseEntity<>(tsrv.getTweets("activo"),HttpStatus.OK);
	}
	
	@GetMapping("/tweet/{id}")
	public ResponseEntity<Object> getTweet(@PathVariable int id){
		Tweet tweet = tsrv.getTweet(id);
		
		HashMap<String,String> response = new HashMap<>();
		
//		if(tweet.getEstatus().equals("eliminado")) {
//			response.put("status","failure");
//			response.put("message","El tweet que se desea consultar ha sido eliminado");
//			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//		}
		
		return new ResponseEntity<>(tweet,HttpStatus.OK);
	}
	
	@PostMapping("/tweet")
	public ResponseEntity<Object> createTweet(@Valid @RequestBody Tweet tweet){
		//tweet.setEstatus("activo");
		tsrv.createTweet(tweet);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tweet creado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/tweet/{id}/{id_persona}")
	public ResponseEntity<Object> updateTweet(@Valid @RequestBody Tweet tweet, @PathVariable int id, @PathVariable int id_persona){
		HashMap<String,String> response = new HashMap<>();
		
//		//Validar ids tweet
//		if(tweet.getId()!=id) {
//			response.put("status","failure");
//			response.put("message","Los ids del tweet no coinciden");
//			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//		}
//		
//		//Validar ids persona
//		if(tweet.getId_persona()!=id_persona) {
//			response.put("status","failure");
//			response.put("message","Los ids de la persona no coinciden");
//			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
//		}
		
		tsrv.updateTweet(tweet);
		
		response.put("status","success");
		response.put("message","Tweet actualizado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/tweet/{id}")
	public ResponseEntity<Object> deleteTweet(@PathVariable int id){
		tsrv.deleteTweet(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tweet eliminado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
