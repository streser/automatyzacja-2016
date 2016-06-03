package com.nokia.integrationtests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public abstract class SeleniumBase {

    public static final By LOGOUT_BUTTON_LOCATOR = By.xpath("(//button[@type='submit'])[2]");

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://pl.wordpress.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void waitForElement(By identifier) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(identifier));
    }

    public String randomName() {
        return UUID.randomUUID().toString();
    }

    protected void openLogInForm() {
        open("/");
        click(By.linkText("Zaloguj się"));
    }

    protected void logIn(String login, String password) {
        insertText(By.id("user_login"), login);
        insertText(By.id("user_pass"), password);

        click(By.id("rememberme"));
        click(By.id("wp-submit"));
    }

    protected void logOut() throws InterruptedException {
        click(By.cssSelector("img.gravatar"));

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(LOGOUT_BUTTON_LOCATOR)) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        click(LOGOUT_BUTTON_LOCATOR);
    }

    private void open(String path) {
        driver.get(baseUrl + path);
    }

    private void click(By identifier) {
        driver.findElement(identifier).click();
    }

    private void insertText(By identifier, String text) {
        driver.findElement(identifier).clear();
        driver.findElement(identifier).sendKeys(text);
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
