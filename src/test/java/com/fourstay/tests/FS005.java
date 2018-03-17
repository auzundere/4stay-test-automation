package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fourstay.pages.GooglePage1;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS005 extends TestBaseClass{
	
	@Test 
	public void Test5() {
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
		HomePage homePage = new HomePage(driver);
		//verify homepage loaded
		assertTrue(homePage.logo.isDisplayed());
		//vefiy the current URL is "https://4stay.com/"
		assertEquals(driver.getCurrentUrl(),"https://4stay.com/");
		//verify the homepage title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
		assertTrue(homePage.isAt());
		
		//Step 2
		homePage.signUp.click();
		SignUpPage signUpPage=new SignUpPage(driver);
		//verify login text-link on thr sign up page is displayed
		assertTrue(signUpPage.loginText.isDisplayed());
		//verify more options text on the sign up page is displayed
		assertTrue(signUpPage.moreOptions.isDisplayed());
		//verify the current URL is "https://4stay.com/sign-up#!/onboarding"
		assertEquals(driver.getCurrentUrl(),"https://4stay.com/sign-up#!/onboarding");
		//verify the homapage title is "Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay"
		assertTrue(signUpPage.isAt());
		
		//Step 3
		//Click more options
		signUpPage.moreOptions.click();
		//Verify "Continue with Facebook" button is displayed
		assertEquals(signUpPage.facebookButton.getText(),"Continue with Facebook");
		//Verify "Continue with Google" button is displayed
		assertEquals(signUpPage.googleButton.getText(),"Continue with Google");
		//Verify "Continue with Email" button is displayed
		assertEquals(signUpPage.emailButton.getText(),"Continue with Email");
		
		//Step 4
		//Click "Continue with Google" button
		signUpPage.googleButton.click();
		//verify we are at the google login page
		GooglePage1 googlePage = new GooglePage1(driver);
		//verify the title of the page is "Sign in - Google Accounts"
		assertTrue(googlePage.isAt());
		
		//Step 5
		//Enter Google account username
		googlePage.EmailOrPhone.sendKeys(Configuration.getProperty("googleuser"));
		//Click on NextButton
		googlePage.NextButton.click();
		//Enter Google account password 
		googlePage.Password.sendKeys(Configuration.getProperty("googlepass"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
