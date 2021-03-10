package com.bae.crudapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.CRUDApp.domain.Meeseeks;
import com.bae.CRUDApp.repo.MeeseeksRepo;
import com.bae.CRUDApp.service.MeeseeksServiceDB; 

@SpringBootTest
@ActiveProfiles("test")
public class MeeseeksServiceDBUnitTest {

	@Autowired
	private MeeseeksServiceDB service;
		
		@MockBean 
		private MeeseeksRepo repo;
		
		//Mockito test for create method 
		@Test 
		void testCreate() {
			Meeseeks newMeeseeks = new Meeseeks("Hugo", "make sandwich", "02/03/20");
			Meeseeks savedMeeseeks = new Meeseeks(1L, "Hugo", "make sandwich", "02/03/20");
			
			Mockito.when(this.repo.save(newMeeseeks)).thenReturn(savedMeeseeks);
			
			assertThat(this.service.createMeeseeks(newMeeseeks)).isEqualTo(savedMeeseeks);
			
			Mockito.verify(this.repo, Mockito.times(1)).save(newMeeseeks);
		}
		
		//Mockito test for update method 
		@Test 
		void testUpdate() {
			Long id = 1L;
			
			Meeseeks newMeeseeks = new Meeseeks("Hugo", "make sandwich", "02/03/20");
			Optional <Meeseeks> optionalMeeseeks = Optional.of(new Meeseeks(id, "Bernard", "fix my code", "03/04/20"));
			
			Meeseeks updatedMeeseeks = new Meeseeks(id, newMeeseeks.getName(), newMeeseeks.getPurpose(), newMeeseeks.getDateActivated());
			
			Mockito.when(this.repo.findById(id)).thenReturn(optionalMeeseeks);
			Mockito.when(this.repo.save(updatedMeeseeks)).thenReturn(updatedMeeseeks);
			
			assertThat(this.service.updateMeeseeks(id, newMeeseeks)).isEqualTo(updatedMeeseeks);
		}
		
		//Mockito test read (get) by id 
		@Test 
		void testGetById() {
	        Long id = 1L;
	        Meeseeks expected = new Meeseeks(id, "Hugo", "make sandwich", "02/03/20");

	        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

	        assertThat(this.service.getMeeseeksById(id)).isEqualTo(expected);

	        // verify
	        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		}
		
		//Mockito test read (get) by name 
		@Test 
		void testGetBName() {
		     String name = "Hugo";
		     Meeseeks expected = new Meeseeks(1L, "Hugo", "make sandwich", "02/03/20");
		     
		     Mockito.when(this.repo.findByName(name)).thenReturn(expected);

		     assertThat(this.service.getMeeseeksByName(name)).isEqualTo(expected);
		        
		     Mockito.verify(this.repo, Mockito.times(1)).findByName(name);
		}
		
	    //Mockito test for read/get all 
		@Test
	    void testGetAll() {

	        Long id = 1L;
	        Meeseeks testMeeseeks = new Meeseeks("Flash", "fix my code", "08/02/20");
	        testMeeseeks.setId(id);
	        
			List<Meeseeks> meeseeks = new ArrayList<>();
			meeseeks.add(testMeeseeks);

	        Mockito.when(this.repo.findAll()).thenReturn(meeseeks);

	        assertThat(this.service.getMeeseeks()).isEqualTo(meeseeks);

	        Mockito.verify(this.repo, Mockito.times(1)).findAll();
	    }
			
		
		//Mockito test for delete method 
		@Test 
		void testExpire() {
			Long id = 1L;
			
	        Mockito.when(this.repo.existsById(id)).thenReturn(false);

	        assertThat(this.service.expireMeeseeks(id)).isTrue();
		}


}
