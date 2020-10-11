package com.restfulwebservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfulwebservices.model.Tweet;
import com.restfulwebservices.repository.TweetRepository;

@Service
public class TweetServiceImp implements TweetService{

	@Autowired
	private TweetRepository trep;
	
	@Override
	public List<Tweet> getTweets(String estatus) {
		return trep.getTweets(estatus);
	}

	@Override
	public Tweet getTweet(int id) {
		return trep.findById(id);
	}

	@Override
	public void createTweet(Tweet tweet) {
		trep.save(tweet);
	}

	@Override
	public void updateTweet(Tweet tweet) {
		trep.save(tweet);
	}

	@Override
	public void deleteTweet(int id) {
		Tweet tweet = getTweet(id);
		//tweet.setEstatus("eliminado");
		trep.save(tweet);
	}

}
