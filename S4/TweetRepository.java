package com.restfulwebservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfulwebservices.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer>{

	Tweet findById(int id);
	
	@Query(value="SELECT * FROM tweet WHERE estatus = :estatus", nativeQuery=true)
	List<Tweet> getTweets(String estatus);
}
