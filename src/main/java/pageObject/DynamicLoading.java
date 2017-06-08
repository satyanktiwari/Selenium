package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends Base {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(startButton).click();
    }

    public Boolean finishTextPresent() {
        return WebDriverWait(finishText);
    }

	
	
}
