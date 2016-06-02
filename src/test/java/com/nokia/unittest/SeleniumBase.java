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

    private WebDriver driver;
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
        click(By.cssSelector("svg.gridicon.gridicons-user-circle  > g > path"));
        waitForElement(By.xpath("(//button[@type='submit'])[2]"));
        click(By.xpath("(//button[@type='submit'])[2]"));
    }

    private void click(By element) {
	driver.findElement(element).click();
    }

    protected void wordpressLogin(String login, String pass) {
        openLoginPage();
        insertTextInto("user_login", login);
        insertTextInto("user_pass", pass);
        click(By.id("wp-submit"));
    }

    private void openLoginPage() {
        driver.get(baseUrl + "/");
        click(By.className("click-wpcom-login"));
    }

    protected void waitForElement(By selector) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60)
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

    private void insertText(By fieldName, String text) {
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

    public String createPost() throws InterruptedException {
	String pName = randomName();
	waitForElement(By.className("masterbar__item-new"));
	click(By.className("masterbar__item-new")); // new post
	insertText(By.className("editor-title__input"),pName);
	//insertTextInto("tinymce-1_ifr", pName);
	
	click(By.className("editor-ground-control__publish-button"));
	return pName;
    }
}