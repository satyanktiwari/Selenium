package test.DaveHaef.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import pageObject.Login;

public class TestLogin {
	private WebDriver driver;
    private Login login;
    
    @BeforeTest
   
    public void beforeTest(){
    	String FirefoxDriverPath = "C:\\Selenium_webdriver_java\\Selenium\\drivers\\geckodriver.exe";
    	System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
    	driver = new FirefoxDriver();
    	login = new Login(driver);
    	
    }
    
    @Test
    
    public void succedded(){
    	login.With("tomsmith", "SuperSecretPassword!");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Assert.assertTrue("success message not present", login.successMessagePresent());
    	
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    
    
}
