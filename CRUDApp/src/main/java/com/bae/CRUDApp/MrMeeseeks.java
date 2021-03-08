package com.bae.CRUDApp;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MrMeeseeks {
	
	private String name;
	private String purpose;
	private LocalDate dateActivated;
	
	//set id as primary key (auto-incremented)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//default constructor 
	public MrMeeseeks() {
		super();
	}
	
	//constructor 
	public MrMeeseeks(String name, String purpose, LocalDate dateActivated) {
		super();
		this.name = name; 
		this.purpose = purpose;
		this.dateActivated = dateActivated;
	}

	//getters and setters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public LocalDate getDateActivated() {
		return dateActivated;
	}

	public void setDateActivated(LocalDate dateActivated) {
		this.dateActivated = dateActivated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
