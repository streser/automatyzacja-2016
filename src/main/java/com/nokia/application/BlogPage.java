package com.nokia.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class BlogPage extends Page {

	public BlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void open() {
		// TODO Auto-generated method stub
		
	}

	public boolean hasPost(final String text){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(new Predicate<WebDriver>() {

			public boolean apply(WebDriver arg0) {
				return driver.getPageSource().contains(text);
			}
		});
	return true;
}

}
