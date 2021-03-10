package com.bae.CRUDApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.CRUDApp.domain.Meeseeks;
import com.bae.CRUDApp.repo.MeeseeksRepo;

@Service 
public class MeeseeksServiceDB implements MeeseeksServiceInterface {
	
	private MeeseeksRepo repo;

	public MeeseeksServiceDB(MeeseeksRepo repo) {
		super();
		this.repo = repo;
	}
	
	//override the methods from the MeeseeksServiceInterface 
	@Override
	public Meeseeks createMeeseeks(Meeseeks meeseeks) {
		return this.repo.save(meeseeks);
	}

	@Override
	public List<Meeseeks> getMeeseeks() {
		return this.repo.findAll();
	}

	@Override
	public Meeseeks getMeeseeksById(Long id) {
		Optional<Meeseeks> optMeeseeks = this.repo.findById(id);
		return optMeeseeks.orElse(null);
	}
	  
	@Override
	public Meeseeks updateMeeseeks(Long id, Meeseeks newMeeseeks) {
		Meeseeks existing = this.getMeeseeksById(id);

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
	public Meeseeks getMeeseeksByName(String name) {
		return this.repo.findByName(name);
	}
}
