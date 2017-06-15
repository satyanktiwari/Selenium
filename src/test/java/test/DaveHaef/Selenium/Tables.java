package test.DaveHaef.Selenium;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tables {
WebDriver driver;

@ BeforeTest
public void setup() throws Exception{
	
	String FirefoxDriverPath = "C:\\Selenium_webdriver_java\\Selenium\\drivers\\geckodriver.exe";
    System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
     driver = new FirefoxDriver();
    System.out.println("@ Before test completed");
}



@ Test
public void withoutHelpfulMarkupDueAscending (){
	System.out.println("inside @Test");
	 driver.get("http://the-internet.herokuapp.com/tables");
	WebElement dcValue = driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)"));
			dcValue.click();
	
	
//	List <WebElement> dues = (List<WebElement>) driver.findElement(By.cssSelector("#table1 tbody td:nth-of-type(4)"));
	List<WebElement> dues = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));
	List<Double> dueValues = new LinkedList<Double>();
	
	for(WebElement element:dues ){
		dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
		System.out.println(dueValues);
		
	}
	
	for (int counter=0; counter < dueValues.size()-1; counter++){
		System.out.println("Value of counter is: "+dueValues.get(counter));
		System.out.println("Value of counter+1 is: "+dueValues.get(counter+1));
		assertThat(dueValues.get(counter), is(lessThanOrEqualTo(dueValues.get(counter+1))));
	}
	
}





@ AfterTest
public void tearDown()throws Exception{
	System.out.println("inside @@ AfterTest");
	driver.quit();
	
}
}
