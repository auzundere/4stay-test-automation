package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS002 extends TestBaseClass{
	/* NOTE:
     * This website accepts only 1 time registration and when you have registered the account, 
     * and try to use same credentials, 
     * it is just logging in. 
     * It is NOT using the registration page any more.
     * Which is if you really create a new account, 
     * it tests that part, and if you have already once, 
     * it will skip those steps in my current try catch block,
     * For this reason, after try catch block, code is finished.
     * 
     * */
	
	@Test 
	public void Test2() throws InterruptedException {
		
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
		//verify the current URL is "https://4stay.com/sign-up#!/onboarding"
		assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding");
		// verify the Home page title is "Sign Up - Room rental, roommate finder,
		// off-campus housing, homestay | 4stay"
		assertTrue(signUpPage.isAt());
		
		//Step 3
		// Click More Options
		signUpPage.moreOptions.click();
		// Verify "Continue with Facebook" button is displayed
		assertEquals(signUpPage.facebookButton.getText(), "Continue with Facebook");
		// Verify "Continue with Google" button is displayed
		assertEquals(signUpPage.googleButton.getText(), "Continue with Google");
		// Verify "Continue with Email" button is displayed
		assertEquals(signUpPage.emailButton.getText(),"Continue with Email");
		
		//Step 4
		// Click "Continue with Facebook" button
		signUpPage.facebookButton.click();
		// verify we are at the Facebook login page
		FacebookPage facebookPage = new FacebookPage(driver);
		// verify the title of the page is "Facebook"
		assertTrue(facebookPage.isAt());
		
		//Step 5
		// Enter facebook account credentials and click login 
		facebookPage.email.sendKeys(Configuration.getProperty("facebookuserhost"));
	    facebookPage.pass.sendKeys(Configuration.getProperty("facebookpasshost"));
		facebookPage.u_0_0.click();
		BrowserUtils.waitForVisibility(homePage.successful, 4);

	    try {
			//BrowserUtils.waitForVisibility(signUpPage.h5IwantToBe, 4);
			assertTrue(signUpPage.h5IwantToBe.isDisplayed());
		}catch(AssertionError e) { 
			//verify home page loaded(the left top corner logo is displayed)
			assertTrue(homePage.logo.isDisplayed());
			//verify pop-up text "Successfully authenticated." is displayed
			BrowserUtils.waitForVisibility(homePage.successful, 4);
			assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
			//verify "Log Out" text is appeared
			assertTrue(homePage.logOut.isDisplayed());
			System.out.println("Test Case FS002 is passed");
			return;   
		}
	    
	    // =======================================================================
		//verify "Host" button is displayed
		//BrowserUtils.waitForVisibility(signUpPage.hostButton, 5);
		assertTrue(signUpPage.hostButton.isDisplayed());
		signUpPage.hostButton.click();
		

	   //Step 7
	   String email = BrowserUtils.generateEmail();
	  // BrowserUtils.waitForVisibility(homePage.successful, 4);
	   signUpPage.emailAddess.clear();
	   signUpPage.emailAddess.sendKeys(email);
	   //enter occupation/school
	   signUpPage.occupationOrSchool.clear();
	   signUpPage.occupationOrSchool.sendKeys("IT");
	   //enter phone number
	   signUpPage.phone.clear();
	   signUpPage.phone.sendKeys("9876543210");
	   //enter something about yourself
	   signUpPage.about_me.clear();
	   signUpPage.about_me.sendKeys("I work in Orange Company.");
	   //enter birth year
	   signUpPage.dob.clear();
	   signUpPage.dob.sendKeys("1986");
	   // click save.
	   signUpPage.saveButton.click();	
		// verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
	   // verify pop-up text "Successfully authenticated." is displayed
		assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
		System.out.println("Test Case FS002 is passed");
				
	}
}
