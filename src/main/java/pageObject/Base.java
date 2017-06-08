//package pageObject;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Base {
//	private WebDriver driver;
//	public Boolean waitForIsDisplayed(By locator, Integer... timeout) {
//        try {
//            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
//                    (timeout.length > 0 ? timeout[0] : null));
//        } catch (org.openqa.selenium.TimeoutException exception) {
//            return false;
//        }
//        return true;
//    }
//
//    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
//        timeout = timeout != null ? timeout : 5;
//        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        wait.until(condition);
//    }
//
//
//    public Boolean WebDriverWait(By selector)
//	{
//
//	    	WebDriverWait wait = new WebDriverWait(driver, 60);
//	    	wait.withTimeout(60, TimeUnit.SECONDS);
//	    	wait.pollingEvery(5, TimeUnit.SECONDS);
//	    	wait.ignoring(NoSuchElementException.class);
//	    	return wait.until(new ExpectedCondition<Boolean>(){
//	    	    @Override
//	    	    public Boolean apply(WebDriver driver) {
//	    	        WebElement ele=driver.findElement(selector);
//	    	        if(ele==null)
//	    	            return false;
//	    	        else
//	    	        {
//	    	            System.out.println("found");
//	    	            return true;
//	    	        }     
//	    	    }
//	    	});
//	}
//
//
//}
