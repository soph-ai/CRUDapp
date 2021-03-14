package com.bae.crudapp.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Sql(scripts = { "classpath:meeseeks-schema.sql",
        "classpath:meeseeks-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class SeleniumTesting {
	
 // @LocalServerPort    
	private int port = 5500;
    private RemoteWebDriver driver;
    WebDriverWait explicitWait;
    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        explicitWait = new WebDriverWait(driver, 5);
    }
    
    @Test    
    void activateMeeseeks() throws InterruptedException {
        this.driver.get("http://localhost:" + port);
        WebElement title = this.driver.findElement(By.xpath("//*[@id=\"homeBody\"]/h1"));
      assertThat(title.getText()).isEqualTo("I'm Mr Meeseeks!");        
        
        // navigate to app page        
        WebElement appButton = this.driver.findElement(By.xpath("//*[@id=\"homeRef\"]/a"));
        appButton.click();
        WebElement title2 = this.driver.findElement(By.xpath("/html/body/main/h1"));
        assertThat(title2.getText()).isEqualTo("Mr Meeseeks Box!");
        
        // activate a Meeseeks        
        Thread.sleep(5000L);
        WebElement meeseeksName = this.explicitWait                
        		.until(ExpectedConditions.presenceOfElementLocated(By.id("meeseeksName")));
        ExpectedConditions.elementToBeSelected(By.id("meeseeksName"));
        meeseeksName.sendKeys("Barry");
        WebElement meeseeksPurpose = this.driver.findElement(By.id("meeseeksPurpose"));
        meeseeksPurpose.sendKeys("Selenium");
        WebElement dateActivated = this.driver.findElement(By.id("dateActivated"));
        dateActivated.sendKeys("22/11/2222");
        WebElement activateButton = this.driver.findElement(By.id("activate"));
        activateButton.click();
        WebElement createdMeeseek = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div[2]/div/div[1]/h5")));
        this.explicitWait.until(ExpectedConditions.textToBePresentInElement(createdMeeseek, "Barry"));
        assertThat(createdMeeseek.getText()).isEqualTo("Barry");
    }

    @Test 
	void editMeeseeks() throws InterruptedException {
        this.driver.get("http://localhost:" + port);
        // navigate to app page        
        WebElement appButton = this.driver.findElement(By.id("homeRef"));
        appButton.click();
        
        //edit meeseeks 
        WebElement edit = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"output\"]/div[1]/div/div[2]/button[2]")));
        driver.executeScript("arguments[0].scrollIntoView(true);",
                this.driver.findElementByXPath("/html/body/main/main/div[4]/a"));
        Thread.sleep(2000L);
        edit.click();
        //Thread.sleep(2000L);
        
        Thread.sleep(5000L);
        WebElement meeseeksNameField = this.explicitWait                
        		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#meeseeksUpdate")));
        ExpectedConditions.elementToBeSelected(By.cssSelector("#meeseeksUpdate"));
        meeseeksNameField.click();
        
        Thread.sleep(5000L);
        WebElement meeseeksName = this.explicitWait                
        		.until(ExpectedConditions.presenceOfElementLocated(By.id("meeseeksName")));
        ExpectedConditions.elementToBeSelected(By.id("meeseeksName"));
        meeseeksName.sendKeys("Paul");
        WebElement meeseeksPurpose = this.driver.findElement(By.id("meeseeksPurpose"));
        meeseeksPurpose.sendKeys("Sel");
        WebElement dateActivated = this.driver.findElement(By.id("meeseeksDateActivated"));
        dateActivated.sendKeys("14/03/2021");
        WebElement updateButton = this.driver.findElement(By.id("update"));
        updateButton.click();
        WebElement editedMeeseek = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"output\"]/div[2]/div/div[1]/h5")));
        this.explicitWait.until(ExpectedConditions.textToBePresentInElement(editedMeeseek, "Paul"));
        assertThat(editedMeeseek.getText()).isEqualTo("Paul"); 
    }
    
    
    @Test    
    	void expireMeeseeks() throws InterruptedException {
        this.driver.get("http://localhost:" + port);
        // navigate to app page        
        WebElement appButton = this.driver.findElement(By.id("homeRef"));
        appButton.click();
        
        // expire test         
        WebElement expire = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"output\"]/div[1]/div/div[2]/button[1]")));
        driver.executeScript("arguments[0].scrollIntoView(true);",
                this.driver.findElementByXPath("/html/body/main/main/div[4]/a"));
        Thread.sleep(2000L);
        expire.click();
        Thread.sleep(2000L);
        List<WebElement> meeseeks = this.driver.findElements(By.cssSelector("#output > div"));
        Assertions.assertTrue(meeseeks.isEmpty());
    }
         
    @AfterEach    
    void tearDown() {
        this.driver.close();
    }
}