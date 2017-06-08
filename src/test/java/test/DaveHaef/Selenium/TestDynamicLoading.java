package test.DaveHaef.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.DynamicLoading;


public class TestDynamicLoading {
	  private WebDriver driver;
	    private DynamicLoading dynamicLoading;
	    
	    @BeforeTest
	    
	    public void beforeTest(){
	    	String FirefoxDriverPath = "C:\\Selenium_webdriver_java\\Selenium\\drivers\\geckodriver.exe";
	    	System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
	    	driver = new FirefoxDriver();
	    	dynamicLoading = new DynamicLoading(driver);	    	
	    }
	    
	    
	    @Test
	    public void hiddenElementLoads() {
	        dynamicLoading.loadExample();
	        Assert.assertTrue("finish text didn't display after loading",
	                dynamicLoading.finishTextPresent());
	    }
	    
	    
	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
}
