package com.bae.crudapp;

import org.springframework.stereotype.Service;

import com.bae.FirstSpring.slothChallenge.SlothRepo;

@Service 
public class MeeseeksServiceDB implements MeeseeksServiceInterface {
	
	private MeeseeksRepo repo;

	public MeeseeksServiceDB(MeeseeksRepo repo) {
		super();
		this.repo = repo;
	}
	
	

}
