package com.bae.CRUDApp;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeeseeksController {
	
	private MeeseeksServiceDB service;

	public MeeseeksController(MeeseeksServiceDB service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createMeeseeks")
	public ResponseEntity<MrMeeseeks> createMeeseeks(@RequestBody MrMeeseeks meeseeks) {
		return new ResponseEntity <MrMeeseeks> (this.service.createMeeseeks(meeseeks), HttpStatus.CREATED);
	}

	@GetMapping("/getMeeseeks")
	public List<MrMeeseeks> getMeeseeks() {
		return this.service.getMeeseeks();
	}

	@GetMapping("/getMeeseeks/{id}")
	public MrMeeseeks getMeeseeksById(@PathVariable Long id) {
		return this.service.getMeeseeksById(id);
	}
	
	@GetMapping("/getMeeseeks/{name}")
	public MrMeeseeks getMeeseeksByName(@PathVariable String name) {
		return this.service.getMeeseeksByName(name);
	}
	
	@PutMapping("/updateMeeseeks/{id}")
	public MrMeeseeks updateMeeseeks(@PathVariable("id") Long id, @RequestBody MrMeeseeks meeseeks) {
        return this.service.updateMeeseeks(id, meeseeks);
    }
	
	@DeleteMapping("/expireMeeseeks/{id}")
	public boolean expireMeeseeks(@PathVariable Long id) {
		return !this.service.expireMeeseeks(id);
	}

}
