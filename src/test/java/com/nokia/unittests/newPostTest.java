package com.nokia.unittests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class newPostTest extends SeleniumBase {
	
	private String title; 
	

	@Test
	public void TestPost() throws Exception {
		title = "Rafal_"+randomName();
		logIn("szkolenieautomatyzacja", "qw12qw12");
		insertPost(title);
		
		checkPostName();

		
	}

	private void checkPostName() {
		driver.get("https://automatyzacjacs.wordpress.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {
			public boolean apply(WebDriver input) {
				return assertThatPostWasAdded(driver, title) != null;
			}
		});
	}

	private void insertPost(String title) {
		click(By.xpath("//div[2]/div/header/a[3]"));
		waitForElement(By.xpath("//div/input"));
		click(By.className("editor-ground-control__publish-button"));
		//insertText(title,By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input"));
		insertText(title, By.className("form-text-input"));
		
		//click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));
		click(By.className("editor-ground-control__publish-button"));
		//Thread.sleep(5000);
		waitForElement(By.linkText("automatyzacjacs"));
	}
	
	private WebElement assertThatPostWasAdded(WebDriver driver, String title) {
		List<WebElement> elemnts = driver.findElements(By.tagName("a"));
		for (WebElement element : elemnts) {
			/*
			 * System.out.println("Old way of debugging;");
			 * System.out.println(element.getAttribute("href"));
			 */
			if (element.getAttribute("href").contains(title.toLowerCase())) {
				return element;
			}
		}
		return null;
	}

	
	private void assertThatPostSuccessful() {
		assertEquals(title, driver.findElement(By.xpath("//div/article[1]/a")).getAttribute("title"));
		///html/body/div[1]/div/div[2]/main/div/article[1]/a
		// /html/body/div[1]/div/div[2]/main/div/article[2]/a
		//html body.home.blog.logged-in.admin-bar.no-customize-support.mp6.customizer-styles-applied.no-featured-posts.highlander-enabled.highlander-light.infinite-scroll div#page.hfeed.site div.site-inner div#content.site-content main#primary.content-area div#posts.posts article#post-247.post-247.post.type-post.status-publish.format-standard.hentry.category-bez-kategorii a.cover-link
	}
	
	public void opennew(String path) {

		driver.get(path);
	}
}
