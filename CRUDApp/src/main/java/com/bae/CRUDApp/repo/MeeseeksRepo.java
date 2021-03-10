package com.bae.CRUDApp.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.CRUDApp.domain.Meeseeks;

public interface MeeseeksRepo extends JpaRepository <Meeseeks, Long> {
	
	Meeseeks findByName(String name);

}
