package com.bae.CRUDApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meeseeks {
	
	private String name;
	private String purpose;
	private String dateActivated;
	
	//set id as primary key (auto-incremented)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//default constructor 
	public Meeseeks() {
		super();
	}
	
	//constructor 
	public Meeseeks(String name, String purpose, String dateActivated) {
		super();
		this.name = name; 
		this.purpose = purpose;
		this.dateActivated = dateActivated;
	}
	
	// constructor(2) for testing 
	public Meeseeks(Long id, String name, String purpose, String dateActivated) {
		super();
		this.name = name;
		this.purpose = purpose;
		this.dateActivated = dateActivated;
		this.id = id;
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

	public String getDateActivated() {
		return dateActivated;
	}

	public void setDateActivated(String dateActivated) {
		this.dateActivated = dateActivated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MrMeeseeks [name=" + name + ", purpose=" + purpose + ", dateActivated=" + dateActivated + ", id=" + id
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateActivated == null) ? 0 : dateActivated.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meeseeks other = (Meeseeks) obj;
		if (dateActivated == null) {
			if (other.dateActivated != null)
				return false;
		} else if (!dateActivated.equals(other.dateActivated))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		return true;
	}	
}
