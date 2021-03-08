package com.bae.crudapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
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

import com.bae.CRUDApp.MrMeeseeks;
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
			MrMeeseeks newMeeseeks = new MrMeeseeks("Hugo", "make sandwich", LocalDate.of(21,03,8));
			String newMeeseeksAsJSON =this.mapper.writeValueAsString(newMeeseeks);
			//Build mock request 
			RequestBuilder mockRequest =post("/createMeeseeks").contentType(MediaType.APPLICATION_JSON).content(newMeeseeksAsJSON);
			
			//Create "saved" meeseeks and convert to JSON 
			MrMeeseeks savedMeeseeks = new MrMeeseeks(1L, "Hugo", "make sandwich", LocalDate.of(21,03,8));
			String savedMeeseeksAsJSON =this.mapper.writeValueAsString(savedMeeseeks);
			
			ResultMatcher matchStatus = status().isCreated();
			ResultMatcher matchBody = content().json(savedMeeseeksAsJSON);
			
			this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);	
			
		}

}
