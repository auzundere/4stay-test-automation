package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.fourstay.pages.GooglePage1;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS004 extends TestBaseClass{
	
	@Test 
	public void Test4() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
				HomePage homePage = new HomePage(driver);
				//verify the Current URL is "https://4stay.com/"
				assertEquals(driver.getCurrentUrl(),"https://4stay.com/");
				//verify the Home page title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(homePage.isAt());
				
				//Step 2
				homePage.signUp.click();
				SignUpPage signUpPage = new SignUpPage(driver);
				//verify login text-link on the sign up page is displayed
				assertTrue(signUpPage.loginText.isDisplayed());
				//verify More Options text on the sign up page is displayed
				assertTrue(signUpPage.moreOptions.isDisplayed());
				//verify the current URL is "https://4stay.com/sign-up#!/onboarding"
				assertEquals(driver.getCurrentUrl(),"https://4stay.com/sign-up#!/onboarding");
				//verify the Home page title is "Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(signUpPage.isAt());
				
				//Step 3
				//Click More Options
				signUpPage.moreOptions.click();
				//Verify "Continue with Facebook" button is displayed
				assertEquals(signUpPage.facebookButton.getText(),"Continue with Facebook");
				//Verify "Continue with Google" button is displayed
				assertEquals(signUpPage.googleButton.getText(),"Continue with Google");
				//Verify "Continue with Email" button is displayed
				assertEquals(signUpPage.emailButton.getText(),"Continue with Email");
				
				//Step 4
				//Click "Continue with Google"  button
				signUpPage.googleButton.click();
				GooglePage1  googlePage= new GooglePage1(driver);
				//Enter  email and click next
			    BrowserUtils.waitForVisibility(googlePage.email, 4);
				googlePage.email.sendKeys(Configuration.getProperty("googleuser"));
				googlePage.nextEmail.click();
				//Enter password and click next
		        BrowserUtils.waitForVisibility(googlePage.password, 4);
				//it will be the password
				googlePage.password.sendKeys(Configuration.getProperty("googlepass"));
				googlePage.nextPassword.click();
			
				//step 5
				//verify "I want to be a" text is displayed
				
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
					return;
				}
				//verify "Host" button is displayed
				//BrowserUtils.waitForVisibility(signUpPage.hostButton, 5);
				assertTrue(signUpPage.hostButton.isDisplayed());
				
				//Step 6
				//verify "Guest" button is displayed
				assertTrue(signUpPage.guestButton.isDisplayed());
				//click guest Button
				signUpPage.guestButton.click();
				//click Next Button
				signUpPage.nextButton.click();
				//verify "Change profile image" button is displayed
				assertTrue(signUpPage.changeProfileImageButton.isDisplayed());
				
				
				//Step 7
				//enter gmail address by generating it
				String email = BrowserUtils.getSaltString() + "@gmail.com";
				signUpPage.emailAddess.click();
				signUpPage.emailAddess.clear();
				signUpPage.emailAddess.sendKeys(email);
				//enter occupation/school
				signUpPage.occupationOrSchool.click();
				signUpPage.occupationOrSchool.clear();
				signUpPage.occupationOrSchool.sendKeys("Student");
				//enter phone number
				signUpPage.phone.click();
				signUpPage.phone.clear();
				signUpPage.phone.sendKeys("4135550505");
				//enter something about yourself
				signUpPage.about_me.click();
				signUpPage.about_me.clear();
				signUpPage.about_me.sendKeys("I am a Computer Science major Student");
				//enter birth year
				signUpPage.dob.click();
				signUpPage.dob.sendKeys("1998");
				//click save.
				signUpPage.saveButton.click();
				//verify home page loaded(the left top corner logo is displayed)
				assertTrue(homePage.logo.isDisplayed());
				
				//verify pop-up text "Successfully authenticated." is displayed
				BrowserUtils.waitForVisibility(homePage.successful, 4);
				assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
				//verify "Log Out" text is appeared
				assertTrue(homePage.logOut.isDisplayed());
		
	}
	
}
