package com.bae.crudapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.CRUDApp.domain.Meeseeks;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:meeseeks-schema.sql", "classpath:meeseeks-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MeeseeksControllerIntegrationTest {
	
		@Autowired
		private MockMvc mockMVC;
		
		@Autowired
		private ObjectMapper mapper;
		
		//test for CREATE method 
		@Test
		void testCreate() throws Exception {
			//create meeseeks and convert to JSON string 
			Meeseeks newMeeseeks = new Meeseeks("Hugo", "make sandwich", "02/03/20");
			String newMeeseeksAsJSON =this.mapper.writeValueAsString(newMeeseeks);
			//Build mock request 
			RequestBuilder mockRequest =post("/createMeeseeks").contentType(MediaType.APPLICATION_JSON).content(newMeeseeksAsJSON);
			
			//Create "saved" meeseeks and convert to JSON 
			Meeseeks savedMeeseeks = new Meeseeks(2L, "Hugo", "make sandwich", "02/03/20");
			String savedMeeseeksAsJSON =this.mapper.writeValueAsString(savedMeeseeks);
			
			ResultMatcher matchStatus = status().isCreated();
			ResultMatcher matchBody = content().json(savedMeeseeksAsJSON);
			
			this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);	
			
		}
		
		//test for READ method 
		@Test 
		void testRead() throws Exception {
			Meeseeks testMeeseeks = new Meeseeks(1L, "Flash", "fix my code", "08/02/20");
			
			List<Meeseeks> allMeeseeks = new ArrayList<>();
			allMeeseeks.add(testMeeseeks);
			
			String testMeeseeksAsJSON = this.mapper.writeValueAsString(allMeeseeks); 
			
			RequestBuilder mockRequest = get("/getMeeseeks");
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(testMeeseeksAsJSON);
			
			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		}
			
		//test for UPDATE method 
		@Test 
		void testUpdate() throws Exception {
			Meeseeks testMeeseeks = new Meeseeks("Flash", "fix my code", "08/02/20");
				
			String testMeeseeksAsJSON = this.mapper.writeValueAsString(testMeeseeks); 
				
			RequestBuilder mockRequest = put("/updateMeeseeks/1").contentType(MediaType.APPLICATION_JSON).content(testMeeseeksAsJSON);
			
			Meeseeks savedMeeseeks = new Meeseeks(1L,"Flash", "fix my code", "08/02/20");
			String savedMeeseeksAsJSON = this.mapper.writeValueAsString(savedMeeseeks); 
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(savedMeeseeksAsJSON);
				
			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		}
		
		//test for DELETE method
		@Test 
		void testDelete() throws Exception {
			RequestBuilder mockRequest = delete("/expireMeeseeks/1");
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().string("false");
				
			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);	
		}

}
