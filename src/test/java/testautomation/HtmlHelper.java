package testautomation;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HtmlHelper {
	public static boolean isElementPresent(WebDriver driver,By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	public static void waitForElement(WebDriver driver, By by) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (HtmlHelper.isElementPresent(driver, by))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
	}
	
	public static void clickElement(WebDriver driver, String name) {
		driver.findElement(By.id(name)).click();
	}
}