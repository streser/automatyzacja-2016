package com.nokia.testautomation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumBlogTest extends SeleniumBase {
	@Test
	public void addPost() throws Exception {
		open("/");
		String name="kk_"+randomName();
		
		logIn("szkolenieautomatyzacja", "qw12qw12");
		// click new post
		click(By.xpath("/html/body/div[2]/div/header/a[3]"));
		
		// input title
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input"));
		insertText(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/input"),
				name);
		
		// click HTML textarea
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/ul/li[2]/a"));
		
		// input textarea text
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"));
		insertText(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/textarea"), "Tekst");

		// publish
		click(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[3]/div/button[1]"));

		
		// wait for green bar
		waitForElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a"));
		
		String link=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[2]/div/a")).getAttribute("href");
		
		
		driver.quit();
		
		driver = new FirefoxDriver();
		driver.get(link);
		
		
		assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/main/article/div/header/h1")).getText(), name);
		
		
	}
	public void waitForElements(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
}
