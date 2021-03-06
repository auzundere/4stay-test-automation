package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.GooglePage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS010 extends TestBaseClass {

	@Test
	public void Test010() {
		// Launch the browser and navigate to www.4stay.com
		driver.get(Configuration.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		// verify the Current URL is "https://fourstay-staging.herokuapp.com/"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// verify the Home page title is "Room rental, roommate finder, off-campus
		// housing, homestay | 4stay"
		assertTrue(homePage.isAt());

		homePage.signUp.click();
		SignUpPage signUpPage = new SignUpPage(driver);
		// verify login text-link on the sign up page is displayed
		assertTrue(signUpPage.loginText.isDisplayed());
		// verify More Options text on the sign up page is displayed
		assertTrue(signUpPage.moreOptions.isDisplayed());
		// verify the current URL is
		// "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding");
		// verify the Home page title is "Sign Up - Room rental, roommate finder,
		// off-campus housing, homestay | 4stay"
		assertTrue(signUpPage.isAt());

		// Click More Options
		signUpPage.moreOptions.click();
		// Verify "Continue with Facebook" button is displayed
		assertEquals(signUpPage.facebookButton.getText(), "Continue with Facebook");
		// Verify "Continue with Google" button is displayed
		assertEquals(signUpPage.googleButton.getText(), "Continue with Google");
		// Verify "Continue with Email" button is displayed
		assertEquals(signUpPage.emailButton.getText(), "Continue with Email");

		// Click "Continue with Email" button
		signUpPage.emailButton.click();
		GooglePage googlePage = new GooglePage(driver);
		// Verify that the registration page appears
		assertTrue(googlePage.termsAndConditions.isDisplayed());

		// Leave input fields empty and Click Save button
		signUpPage.saveButton.click();
		// verify that " Please fill out this field" message appears
		// title before clicking the save button
		String titleBeforeSave = driver.getTitle();
		// title after clicking the save button
		String titleAfterSave = driver.getTitle();
		// verify both titles are same
		assertEquals(titleBeforeSave, titleAfterSave, "Fields are empty, can not save!");

	}
}
