package com.bae.crudapp.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@Test
		void testMeeseeks() {
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
			
			
//			//expire Meeseeks 
//			WebElement expireButton = this.driver.findElement(
//					By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]"));
//			expireButton.click();
			
			WebDriverWait explicitWait = new WebDriverWait(driver, 5);
			WebElement expire = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]")));
			expire.click();
//			
//			WebElement expireButton = this.driver.findElement(
//			By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[1]"));
//		    new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(myModal));
//
//		    expireButton.click();
		    
			//test to see if modal is not visible (blocking other things) 
			WebElement modal = this.driver.findElement(
			By.xpath("//*[@id=\"myModal\"]"));
		    new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(modal));

			
			//edit Meeseeks 

//			WebElement editButton = this.driver.findElement(
//					By.xpath("//*[@id=\"output\"]/div/div/div[2]/button[2]"));
//			editButton.click();
//			
		}
		
		

	}
