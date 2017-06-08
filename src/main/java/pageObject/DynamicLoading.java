package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading {
//	http://the-internet.herokuapp.com/dynamic_loading/2
//	By startButton = By.cssSelector("#Start button");
	By startButton = By.id("start");
	By finishText = By.id("finish");
	private WebDriver driver;
	
	public DynamicLoading(WebDriver driver) {
		this.driver = driver;
    }
	
	public void loadExample() {
//        System.out.println("http://the-internet.herokuapp.com/dynamic_loading/"+ exampleNumber);
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
//        waitForIsDisplayed(startButton);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Internet"));
		wait.until(ExpectedConditions.elementToBeClickable(startButton));
		driver.findElement(startButton).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(finishText));
		String text = driver.findElement(finishText).getText();
		System.out.println("text is: "+text);
    }

    
	
}
