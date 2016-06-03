package com.nokia.unittests;

import java.util.List;

import com.google.common.base.Predicate;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostTest extends SeleniumBase {

	private String uniqueNumber;

	@Test
	public void shouldNewPostAdded() throws InterruptedException {
		openLoginForm();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		uniqueNumber = "adamp-" + randomName();
		createNewPost(uniqueNumber);
		driver.get("https://automatyzacjacs.wordpress.com/");
		checkPostName();
	}

	private void checkPostName() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {
			public boolean apply(WebDriver input) {
				return assertThatPostWasAdded(driver) != null;
			}
		});
	}

	private void createNewPost(String uniqueNumber) {
		waitForElement(By.className("masterbar__item-new"));
		click(By.className("masterbar__item-new"));
		waitForElement(By.className("form-text-input"));
		insertText(By.className("form-text-input"), uniqueNumber);
		click(By.className("editor-ground-control__publish-button"));
		waitForElement(By.linkText("automatyzacjacs"));

	}

	private WebElement assertThatPostWasAdded(WebDriver driver) {
		List<WebElement> elemnts = driver.findElements(By.tagName("a"));
		for (WebElement element : elemnts) {
			/*
			 * System.out.println("Old way of debugging");
			 * System.out.println(element.getAttribute("href"));
			 */
			if (element.getAttribute("href").contains(uniqueNumber)) {
				return element;
			}
		}
		return null;
	}
}
