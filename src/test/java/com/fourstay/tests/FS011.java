package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS011 extends TestBaseClass {
	@Test
	public void Test11() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);

		HomePage homePage = new HomePage(driver);
		// verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
		// verify the Current URL is "https://4stay.com/"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// verify the Home page title is "Room rental, roommate finder, off-campus
		// housing, homestay | 4stay"
		assertTrue(homePage.isAt());

		homePage.loginLink.click();
		BrowserUtils.waitForVisibility(loginPage.user_email, 1);
		assertTrue(loginPage.user_email.isDisplayed(), "email field was not displayed!");
		assertTrue(loginPage.user_password.isDisplayed(), "password field was not displayed!");
		assertTrue(loginPage.loginWithFacebook.isDisplayed(), "Login with Facebook was not displayed!");
		assertTrue(loginPage.loginWithGoogle.isDisplayed(), "Login with Google was not displayed!");

		loginPage.loginWithFacebook.click();
		// There is a bug right here. We can't do the rest.

	}

}
