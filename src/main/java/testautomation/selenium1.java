package testautomation;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;

@SuppressWarnings("unused")
public class selenium1 extends seleniumSuperClass {
/*	@SuppressWarnings("unused")
	private void assertThatLogInWasSuccessful() {
		Assert.assertTrue(isElementPresent(By.xpath("//header[@id = 'header']/a2/span")));
*/

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
