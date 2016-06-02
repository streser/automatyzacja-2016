package com.nokia.unittest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class WordpressLoginTest extends SeleniumBase {

    @Test
    public void testLoginWordPress() throws Exception {
	wordpressLogin("szkolenieautomatyzacja", "qw12qw12");
	assertLoginSuccessfull();
	wordpressLogout();
	// verify logged out
	waitForElement(By.className("click-wpcom-login"));
    }

    private void assertLoginSuccessfull() throws InterruptedException {
	waitForElement(By.cssSelector("svg.gridicon.gridicons-user-circle"));
	assertTrue(isElementPresent(By.cssSelector("svg.gridicon.gridicons-user-circle")));
    }

}