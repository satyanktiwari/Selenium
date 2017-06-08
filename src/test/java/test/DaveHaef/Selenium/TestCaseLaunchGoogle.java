package test.DaveHaef.Selenium;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DaveHaef.Selenium.OpenGoogle;
import utility.Log;


public class TestCaseLaunchGoogle {
	private WebDriver driver;
	@BeforeTest
	
	public void beforeTest(){
//		DOMConfigurator.configure("Sel.log4j.xml");
		String chromeDriverPath = "C:\\Selenium_webdriver_java\\Selenium_java_practice\\drivers\\chromedriver.exe";
//		Log.info("Chrome Driver found");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//		Log.info("Property Set");
		driver = new ChromeDriver();
//		Log.info("Driver available and before test completed");
	}
	
	@ Test
	
	public void test(){
		
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String element = driver.getTitle();
		System.out.println("Title is: "+element);
	}
	
	@AfterTest
	
	public void after(){
		driver.close();
		driver.quit();
	}
	
	
	
}
