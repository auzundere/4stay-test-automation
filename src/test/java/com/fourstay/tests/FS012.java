package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.GooglePage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS012 extends TestBaseClass {

	@Test
	public void Test1() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);

		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.logo.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		assertTrue(homePage.isAt());

		homePage.loginLink.click();
		BrowserUtils.waitForVisibility(loginPage.user_email, 1);
		assertTrue(loginPage.user_email.isDisplayed(), "email field was not displayed!");
		assertTrue(loginPage.user_password.isDisplayed(), "password field was not displayed!");
		assertTrue(loginPage.loginWithFacebook.isDisplayed(), "Login with Facebook was not displayed!");
		assertTrue(loginPage.loginWithGoogle.isDisplayed(), "Login with Google was not displayed!");

		loginPage.loginWithGoogle.click();
		GooglePage googlePage = new GooglePage(driver);
		googlePage.email.sendKeys(Configuration.getProperty("googleuser"));
		googlePage.nextEmail.click();
		googlePage.password.sendKeys(Configuration.getProperty("googlepass"));
		googlePage.nextPassword.click();
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.popUpPleaseEnter.isDisplayed());
		assertTrue(homePage.logOut.isDisplayed());

	}
}
