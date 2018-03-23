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

public class FS009 extends TestBaseClass{
	
	@Test 
	public void Test9() throws InterruptedException {
		
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
		HomePage homePage = new HomePage(driver);
		// verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
		// verify the Current URL is "https://4stay.com/"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// verify the Home page title is "Room rental, roommate finder, off-campus
		// housing, homestay | 4stay"
		assertTrue(homePage.isAt());
		
		//Step 2
		homePage.signUp.click();
		SignUpPage signUpPage = new SignUpPage(driver);
		// verify login text-link on the sign up page is displayed

		assertTrue(signUpPage.loginText.isDisplayed());
		// verify the current URL is "https://4stay.com/sign-up#!/onboarding"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding");
		// verify the Home page title is "Sign Up - Room rental, roommate finder,
		// off-campus housing, homestay | 4stay"
		assertTrue(signUpPage.isAt());

		// Step 3
		// Click More Options
		signUpPage.moreOptions.click();
		// Verify "Continue with Facebook" button is displayed
		assertEquals(signUpPage.facebookButton.getText(), "Continue with Facebook");
		// Verify "Continue with Google" button is displayed
		assertEquals(signUpPage.googleButton.getText(), "Continue with Google");
		// Verify "Continue with Email" button is displayed
		assertEquals(signUpPage.emailButton.getText(),"Continue with Email");
		
		//Step 4
		// Click "Continue with Email" button
		signUpPage.emailButton.click();
		// verify we are at the Email login page
		// verify the current URL is "https://4stay.com/sign-up#!/basic-information"
		assertTrue(driver.getCurrentUrl().equals("https://fourstay-staging.herokuapp.com/sign-up#!/basic-information"));
		//Verify "First name*" textbox is displayed
		assertTrue(signUpPage.firstName.isDisplayed());
		//Verify "First name*" textbox is displayed
		assertTrue(signUpPage.lastName.isDisplayed());
		// Verify "Email address*" textbox is displayed
		assertTrue(signUpPage.emailAddess.isDisplayed());
		// Verify "New password:" text is displayed
		assertTrue(signUpPage.password.isDisplayed());
		
		//Step 5
		// Fill aout the fields
		String email = BrowserUtils.generateEmail().toLowerCase();
		signUpPage.firstName.sendKeys(Configuration.getProperty("firstname"));
		signUpPage.lastName.sendKeys(Configuration.getProperty("lastname"));
		signUpPage.emailAddess.sendKeys(email);
		signUpPage.password.sendKeys(Configuration.getProperty("passLessthen6"));
		signUpPage.signUpButton.click();
		assertTrue(signUpPage.errorMsg.isDisplayed());
		
	}
}














