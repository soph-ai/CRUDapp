package com.bae.crudapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeeseeksRepo extends JpaRepository <MrMeeseeks, Long> {
	
	MrMeeseeks findByName(String name);

}
