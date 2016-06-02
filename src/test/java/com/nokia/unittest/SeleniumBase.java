package com.nokia.unittest;

import static org.junit.Assert.fail;

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
        driver.findElement(By.cssSelector("svg.gridicon.gridicons-user-circle  > g > path")).click();
        waitForElement(By.xpath("(//button[@type='submit'])[2]"));
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    protected void wordpressLogin(String login, String pass) {
        openLoginPage();
        insertTextInto("user_login", login);
        insertTextInto("user_pass", pass);
        driver.findElement(By.id("wp-submit")).click();
    }

    private void openLoginPage() {
        driver.get(baseUrl + "/");
        driver.findElement(By.className("click-wpcom-login")).click();
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
        driver.findElement(By.id(fieldName)).clear();
        driver.findElement(By.id(fieldName)).sendKeys(text);
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

}