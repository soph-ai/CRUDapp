package com.bae.CRUDApp;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service 
public class MeeseeksServiceDB implements MeeseeksServiceInterface {
	
	private MeeseeksRepo repo;

	public MeeseeksServiceDB(MeeseeksRepo repo) {
		super();
		this.repo = repo;
	}
	
	//override the methods from the MeeseeksServiceInterface 
	@Override
	public MrMeeseeks createMeeseeks(MrMeeseeks meeseeks) {
		return this.repo.save(meeseeks);
	}

	@Override
	public List<MrMeeseeks> getMeeseeks() {
		return this.repo.findAll();
	}

	@Override
	public MrMeeseeks getMeeseeksById(Long id) {
		Optional<MrMeeseeks> optMeeseeks = this.repo.findById(id);
		return optMeeseeks.orElse(null);
	}
	  
	@Override
	public MrMeeseeks updateMeeseeks(Long id, MrMeeseeks newMeeseeks) {
		MrMeeseeks existing = this.getMeeseeksById(id);

		existing.setDateActivated(newMeeseeks.getDateActivated());
		existing.setName(newMeeseeks.getName());
		existing.setPurpose(newMeeseeks.getPurpose());

		return this.repo.save(existing);
	}

	@Override
	public boolean expireMeeseeks(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	@Override
	public MrMeeseeks getMeeseeksByName(String name) {
		return this.repo.findByName(name);
	}
}
