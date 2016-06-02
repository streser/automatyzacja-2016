package com.nokia.integrationtests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LogInTest {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAutomatyzacja() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys("szkolenieautomatyzacja");
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys("qw12qw12");
        driver.findElement(By.id("rememberme")).click();
        driver.findElement(By.id("wp-submit")).click();
        assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
        driver.findElement(By.cssSelector("img.gravatar")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("(//button[@type='submit'])[2]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
