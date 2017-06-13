package test.DaveHaef.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FluentWait {
	private static WebDriver driver;
	static By fromTag = By.id("FromTag");
	static By to = By.id("ToTag");
	static By depart = By.id("DepartDate");
	static By search = By.id("SearchBtn");
	static By multi = By.id("1_1_MULTI");
	final static String	baseURL = "http://www.cleartrip.com/";
	
	@BeforeTest
	public static void before(){
	

	String FirefoxDriverPath = "C:\\Selenium_webdriver_java\\Selenium\\drivers\\geckodriver.exe";
    System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
	}
	
	
	@Test
	public static void test () throws Exception{
	WebDriver driver = new FirefoxDriver();
	driver.get(baseURL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(fromTag).sendKeys("blr");
	driver.findElement(to).sendKeys("ccu");
	driver.findElement(depart).sendKeys("Sun, 18 Jun, 2017");
	driver.findElement(depart).sendKeys(Keys.ENTER);
	driver.findElement(search).click();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.pollingEvery(2, TimeUnit.SECONDS);
//	wait.ignoringAll([NoSuchElementException,ElementNotVisibleException,ElementNotSelectableException]);
	wait.until(ExpectedConditions.elementToBeClickable(multi));

	}
	
	@AfterTest
	public static void tearDown(){
		driver.close();
		driver.quit();
		
	}
}
