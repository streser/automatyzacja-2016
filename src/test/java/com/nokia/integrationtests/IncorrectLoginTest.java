package com.nokia.integrationtests;

import org.junit.Assert;
import org.junit.Test;
import com.nokia.application.model.LoginPage;

public class IncorrectLoginTest extends TestScrenario {

    @Test
    public void loginShouldFailWithIncorrectCredentials() throws InterruptedException {
	LoginPage lp = new LoginPage(driver);
	Assert.assertNull(lp.logIn("wrong login", "wrong pass"));
    }
}
	