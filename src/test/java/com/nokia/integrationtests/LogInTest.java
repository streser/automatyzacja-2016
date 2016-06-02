package com.nokia.integrationtests;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class LogInTest extends SeleniumBase {

    @Test
    public void userWithCorrectCredentialsIsSuccessfullyLoggedIn() throws Exception {
        openLogInForm();

        logIn("szkolenieautomatyzacja", "qw12qw12");

        assertThatLogInWasSuccesful();
        logOut();
    }

    private void assertThatLogInWasSuccesful() {
        assertTrue(isElementPresent(By.xpath("//header[@id='header']/a[2]/span")));
    }

}
