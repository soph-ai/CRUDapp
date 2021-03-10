package com.bae.CRUDApp.controller;

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

import com.bae.CRUDApp.domain.Meeseeks;
import com.bae.CRUDApp.service.MeeseeksServiceDB;

@RestController
public class MeeseeksController {
	
	private MeeseeksServiceDB service;

	public MeeseeksController(MeeseeksServiceDB service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createMeeseeks")
	public ResponseEntity<Meeseeks> createMeeseeks(@RequestBody Meeseeks meeseeks) {
		return new ResponseEntity <Meeseeks> (this.service.createMeeseeks(meeseeks), HttpStatus.CREATED);
	}

	@GetMapping("/getMeeseeks")
	public ResponseEntity<List<Meeseeks>> getMeeseeks() {
		return ResponseEntity.ok(this.service.getMeeseeks());
	}

	@GetMapping("/getMeeseeks/{id}")
	public Meeseeks getMeeseeksById(@PathVariable Long id) {
		return this.service.getMeeseeksById(id);
	}
	
	@GetMapping("/getMeeseeks/{name}")
	public Meeseeks getMeeseeksByName(@PathVariable String name) {
		return this.service.getMeeseeksByName(name);
	}
	
	@PutMapping("/updateMeeseeks/{id}")
	public Meeseeks updateMeeseeks(@PathVariable("id") Long id, @RequestBody Meeseeks meeseeks) {
        return this.service.updateMeeseeks(id, meeseeks);
    }
	
	@DeleteMapping("/expireMeeseeks/{id}")
	public boolean expireMeeseeks(@PathVariable Long id) {
		return !this.service.expireMeeseeks(id);
	}

}
