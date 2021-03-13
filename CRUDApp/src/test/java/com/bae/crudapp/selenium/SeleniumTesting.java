package com.bae.crudapp.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTesting {
		
		@LocalServerPort
		private int port;
		
		private RemoteWebDriver driver;
		
		@BeforeEach 
		void setup() {
			this.driver = new ChromeDriver();
			this.driver.manage().window().maximize();
		}
		
		@Test
		void testMeeseeks() {
			this.driver.get("http://localhost:" + port);
			
			WebElement title = this.driver.findElement(By.xpath("//*[@id=\"homeBody\"]/h1"));

			assertThat(title.getText()).isEqualTo("Mr Meeseeks Adventure!");
		}

	}
