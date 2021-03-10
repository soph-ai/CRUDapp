package com.bae.CRUDApp.service;


import java.util.List;

import com.bae.CRUDApp.domain.Meeseeks;

public interface MeeseeksServiceInterface {
	
	Meeseeks createMeeseeks(Meeseeks meeseeks);

	List<Meeseeks> getMeeseeks();

	Meeseeks getMeeseeksById(Long id);
	
	Meeseeks getMeeseeksByName(String name);

	boolean expireMeeseeks(Long id);
	
	Meeseeks updateMeeseeks(Long id, Meeseeks newMeeseek);

}
