package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS001 extends TestBaseClass {

	@Test
	public void Test1() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		// verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
		// verify the Current URL is "https://4stay.com/"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// verify the Home page title is "Room rental, roommate finder, off-campus
		// housing, homestay | 4stay"
		assertTrue(homePage.isAt());
		System.out.println("Step 1 is done");

		homePage.signUp.click();
		SignUpPage signUpPage = new SignUpPage(driver);
		// verify login text-link on the sign up page is displayed
		assertTrue(signUpPage.loginText.isDisplayed());
		// verify More Options text on the sign up page is displayed
		assertTrue(signUpPage.moreOptions.isDisplayed());
		// verify the current URL is "https://4stay.com/sign-up#!/onboarding"
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

		// Click "Continue with Facebook" button
		signUpPage.facebookButton.click();
		// verify we are at the Facebook login page
		FacebookPage facebookPage = new FacebookPage(driver);
		// verify the title of the page is "Facebook"
		assertTrue(facebookPage.isAt());
		// Verify "Email or Phone:" text is displayed
		assertTrue(facebookPage.emailOrPhoneLabel.isDisplayed());
		// Verify "Password:" text is displayed
		assertTrue(facebookPage.passwordLabel.isDisplayed());

		// Enter facebook account credentials and click login
		facebookPage.email.sendKeys(Configuration.getProperty("facebookuser"));
		facebookPage.pass.sendKeys(Configuration.getProperty("facebookpass"));
		facebookPage.u_0_0.click();
		try {
			// verify "I want to be a" text is displayed
			assertTrue(signUpPage.h5IwantToBe.isDisplayed());
		} catch (AssertionError e) {
			// verify home page loaded(the left top corner logo is displayed)
			assertTrue(homePage.logo.isDisplayed());
			// verify pop-up text "Successfully authenticated." is displayed
			assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
			// verify "Log Out" text is appeared
			assertTrue(homePage.logOut.isDisplayed());
			System.out.println("Test Case FS001 is passed");
			return;
		}
		// verify "Host" button is displayed
		// BrowserUtils.waitForVisibility(signUpPage.hostButton, 5);
		assertTrue(signUpPage.hostButton.isDisplayed());

		// verify "Guest" button is displayed
		assertTrue(signUpPage.guestButton.isDisplayed());
		// click guest Button
		signUpPage.guestButton.click();
		// click Next Button
		signUpPage.nextButton.click();
		// verify "Change profile image" button is displayed
		assertTrue(signUpPage.changeProfileImageButton.isDisplayed());
		// generate a gmail
		String email = BrowserUtils.generateEmail();
		Thread.sleep(2000);
		signUpPage.emailAddess.clear();
		signUpPage.emailAddess.sendKeys(email);
		// enter occupation/school
		signUpPage.occupationOrSchool.clear();
		signUpPage.occupationOrSchool.sendKeys("SDET");
		// enter phone number
		signUpPage.phone.clear();
		signUpPage.phone.sendKeys("2011234567");
		// enter something about yourself
		signUpPage.about_me.clear();
		signUpPage.about_me.sendKeys("I am SDET and I have 7 years of experience in Test Automation.");
		// enter birth year
		signUpPage.dob.clear();
		signUpPage.dob.sendKeys("1974");
		// click save.
		signUpPage.saveButton.click();
		// verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
		// verify pop-up text "Successfully authenticated." is displayed
		assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
		// verify "Log Out" text is appeared
		assertTrue(homePage.logOut.isDisplayed());
		System.out.println("Test Case FS001 is passed");
	}

}
