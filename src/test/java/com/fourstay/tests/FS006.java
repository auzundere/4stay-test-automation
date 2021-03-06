package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.GooglePage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS006 extends TestBaseClass {

	@Test
	public void Test6() {
		driver.get(Configuration.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.logo.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		assertTrue(homePage.isAt());

		homePage.signUp.click();
		SignUpPage signUpPage = new SignUpPage(driver);
		BrowserUtils.waitForVisibility(signUpPage.loginText, 5);
		assertTrue(signUpPage.loginText.isDisplayed());
		assertTrue(signUpPage.moreOptions.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding");
		assertTrue(signUpPage.isAt());

		signUpPage.moreOptions.click();
		assertEquals(signUpPage.facebookButton.getText(), "Continue with Facebook");
		assertEquals(signUpPage.googleButton.getText(), "Continue with Google");
		assertEquals(signUpPage.emailButton.getText(), "Continue with Email");

		signUpPage.googleButton.click();
		GooglePage googlePage = new GooglePage(driver);
		BrowserUtils.waitForVisibility(googlePage.email, 4);
		googlePage.email.sendKeys(Configuration.getProperty("googleuser"));
		googlePage.nextEmail.click();
		BrowserUtils.waitForVisibility(googlePage.password, 4);
		googlePage.password.sendKeys(Configuration.getProperty("googlepass"));
		googlePage.nextPassword.click();

		try {
			assertTrue(signUpPage.h5IwantToBe.isDisplayed());
		} catch (AssertionError e) {
			assertTrue(homePage.logo.isDisplayed());
			BrowserUtils.waitForVisibility(homePage.successful, 4);
			assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
			assertTrue(homePage.logOut.isDisplayed());
			System.out.println("Test Case FS006 is passed");
			return;
		}
		assertTrue(signUpPage.hostButton.isDisplayed());

		assertTrue(signUpPage.guestButton.isDisplayed());
		signUpPage.guestButton.click();
		signUpPage.nextButton.click();
		assertTrue(signUpPage.changeProfileImageButton.isDisplayed());

		signUpPage.dob.click();
		signUpPage.dob.sendKeys("35022");
		signUpPage.saveButton.click();
		assertTrue(signUpPage.saveButton.isDisplayed());
		System.out.println("Test Case FS006 is passed");

	}

}
