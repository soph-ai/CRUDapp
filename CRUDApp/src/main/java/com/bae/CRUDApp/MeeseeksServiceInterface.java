package com.bae.crudapp;

import java.util.List;

public interface MeeseeksServiceInterface {
	
	MrMeeseeks createMeeseeks(MrMeeseeks meeseeks);

	List<MrMeeseeks> getMeeseeks();

	MrMeeseeks getMeeseeksById(Long id);
	
	MrMeeseeks getMeeseeksByName(String name);

	boolean expireMeeseeks(Long id);
	
	MrMeeseeks updateMeeseeks(Long id, MrMeeseeks newMeeseek);

}
