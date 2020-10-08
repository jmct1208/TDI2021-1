package com.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.model.*;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
