package com.nokia.unittest;

import static org.junit.Assert.fail;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBase {

    protected WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public SeleniumBase() {
	super();
    }

    @Before
    public void setUp() throws Exception {
	driver = new FirefoxDriver();
	baseUrl = "https://wordpress.com";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void wordpressLogout() throws InterruptedException {
	click(By.className("masterbar__item-me"));
	acceptAlertIfPresent();
	waitForElement(By.xpath("(//button[@type='submit'])[2]"));
	click(By.xpath("(//button[@type='submit'])[2]"));
    }

    public void click(By element) {
	driver.findElement(element).click();
    }

    protected void wordpressLogin(String login, String pass) throws InterruptedException {
	openLoginPage();
	insertTextInto("user_login", login);
	insertTextInto("user_pass", pass);
	click(By.id("wp-submit"));
    }

    private void openLoginPage() throws InterruptedException {
	driver.get(baseUrl + "/");
	waitForElement(By.className("click-wpcom-login"));
	click(By.className("click-wpcom-login"));
    }

    public void openUrl(String url) {
	driver.get(url);
    }

    protected void waitForElement(By selector) throws InterruptedException {
	for (int second = 0;; second++) {
	    if (second >= 10)
		fail("timeout");
	    try {
		if (isElementPresent(selector))
		    break;
	    } catch (Exception e) {
	    }
	    Thread.sleep(1000);
	}
    }

    private void insertTextInto(String fieldName, String text) {
	insertText(By.id(fieldName), text);
    }

    protected void insertText(By fieldName, String text) {
	driver.findElement(fieldName).clear();
	driver.findElement(fieldName).sendKeys(text);
    }

    @After
    public void tearDown() throws Exception {
	driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	}
    }

    protected boolean isElementPresent(By by) {
	try {
	    driver.findElement(by);
	    return true;
	} catch (NoSuchElementException e) {
	    return false;
	}
    }

    public String randomName() {
	return "witw " + UUID.randomUUID().toString();
    }

    public void switchFrame(By frame) {
	driver.switchTo().frame(driver.findElement(frame));
    }

    public void switchFrame() {
	driver.switchTo().defaultContent();
    }
    
    public boolean isAlertPresent() {
	    try {
	        driver.switchTo().alert();
	        return true;
	    }
	    catch (Exception e) {
	        return false;
	    }
	}
    
    public void acceptAlertIfPresent() {
	if (!isAlertPresent()) return;
	driver.switchTo().alert();
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
    }
    
}