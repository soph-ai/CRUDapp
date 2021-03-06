package com.bae.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MrMeeseeks {
	
	private String name;
	private String hair;
	private String purpose;
	private int age;
	
	//set id as primary key (auto-incremented)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//default constructor 
	public MrMeeseeks() {
		super();
	}
	
	//constructor 
	public MrMeeseeks(String name, String hair, String purpose, int age) {
		super();
		this.name = name; 
		this.hair = hair;
		this.hair = hair;
		this.age = age;
	}

}
