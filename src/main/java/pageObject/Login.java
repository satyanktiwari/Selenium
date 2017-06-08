package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
private WebDriver driver;

By userNameLocator = By.id("username");
By passwordLocator = By.id("password");
By loginFormLocator = By.id("login");
//class="flash success" hence ".flash.success"
By successMessageLocator = By.cssSelector(".flash.success");
By failureMessageLocator = By.cssSelector(".flash.error");

public Login (WebDriver driver) {
	this.driver = driver;
	driver.get("http://the-internet.herokuapp.com/login");	
	}
public void With(String username, String password){
	
	driver.findElement(userNameLocator).sendKeys(username);
	driver.findElement(passwordLocator).sendKeys(password);
	driver.findElement(loginFormLocator).submit();
}

public boolean successMessagePresent(){
	return driver.findElement(successMessageLocator).isDisplayed();
}

public boolean failureMessagePresent(){
	return driver.findElement(failureMessageLocator).isDisplayed();
}

}
