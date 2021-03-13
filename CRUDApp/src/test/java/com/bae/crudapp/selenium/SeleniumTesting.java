package com.bae.crudapp.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"classpath:meeseeks-schema.sql", "classpath:meeseeks-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SeleniumTesting {
		
		@LocalServerPort
		private int port;
		
		private RemoteWebDriver driver;
		
		@BeforeEach 
		void setup() {
			this.driver = new ChromeDriver();
			this.driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@Test
		void activateMeeseeks() {
			this.driver.get("http://localhost:" + port);
			
			WebElement title = this.driver.findElement(By.xpath("//*[@id=\"homeBody\"]/h1"));
			assertThat(title.getText()).isEqualTo("Mr Meeseeks Adventure!");
			
			//navigate to app page 
			WebElement appButton = this.driver.findElement(
					By.xpath("//*[@id=\"homeRef\"]/a"));
			appButton.click();
			
			WebElement title2 = this.driver.findElement(By.xpath("/html/body/main/h1"));
			assertThat(title2.getText()).isEqualTo("Mr Meeseeks Box!");
			
			
			//activate a Meeseeks 
			WebElement meeseeksName = this.driver.findElement(By.xpath(
					"//*[@id=\"meeseeksName\"]"));

			meeseeksName.sendKeys("Flash");
			
			WebElement meeseeksPurpose = this.driver.findElement(By.xpath(
					"//*[@id=\"meeseeksPurpose\"]"));

			meeseeksPurpose.sendKeys("Fix my code!");
			
			
			WebElement dateActivated = this.driver.findElement(
					By.xpath("//*[@id=\"dateActivated\"]"));
			dateActivated.sendKeys("11/03/2021");;
			
			WebElement activateButton = this.driver.findElement(
					By.xpath("//*[@id=\"activate\"]"));
			activateButton.click();
			
		}
			
			
//			//expire Meeseeks 
//			WebElement expireButton = this.driver.findElement(
//					By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]"));
//			expireButton.click();
			
//			WebDriverWait explicitWait = new WebDriverWait(driver, 5);
//			WebElement expire = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]")));
//			expire.click();
//			
//			WebElement expireButton = this.driver.findElement(
//			By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]"));
//		    new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(myModal));
//
//		    expireButton.click();
			
			@Test
			void expireMeeseeks() {
				this.driver.get("http://localhost:" + port);
			
			//navigate to app page
			WebElement appButton = this.driver.findElement(
					By.xpath("//*[@id=\"homeRef\"]/a"));
			appButton.click();
		    
			//test to see if modal is not visible (blocking other things) 
			WebElement modal = this.driver.findElement(
			By.xpath("//*[@id=\"myModal\"]"));
		    new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(modal));

			WebDriverWait explicitWait = new WebDriverWait(driver, 5);
			WebElement expire = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div[1]/div/div[2]/button[1]")));
			
			driver.executeScript("arguments[0].scrollIntoView(true);", expire);
			expire.click();
			
			//edit Meeseeks 

//			WebElement editButton = this.driver.findElement(
//					By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[2]"));
//			editButton.click();
//			
		}	
			
		@AfterEach 
		void tearDown() {
//			this.driver.close();
		}
		

	}
