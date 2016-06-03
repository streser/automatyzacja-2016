package com.nokia.application.model;

import static org.junit.Assert.fail;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
	this.driver = driver;
    }

    public void openUrl(String url) {
	driver.get(url);
    }

    public void click(By element) {
	driver.findElement(element).click();
    }

    protected void insertTextInto(String fieldName, String text) {
	insertText(By.id(fieldName), text);
    }

    protected void insertText(By fieldName, String text) {
	driver.findElement(fieldName).clear();
	driver.findElement(fieldName).sendKeys(text);
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
	} catch (Exception e) {
	    return false;
	}
    }

    public void acceptAlertIfPresent() {
	if (!isAlertPresent())
	    return;
	driver.switchTo().alert().accept();
	driver.switchTo().defaultContent();
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

    public void logOut() throws InterruptedException {
	click(By.className("masterbar__item-me"));
	acceptAlertIfPresent();
	waitForElement(By.xpath("(//button[@type='submit'])[2]"));
	click(By.xpath("(//button[@type='submit'])[2]"));
    }

}
