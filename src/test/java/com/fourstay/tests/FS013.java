package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS013 extends TestBaseClass {
	
	
	@Test
	public void Test1() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		
		//Step 1
				HomePage homePage = new HomePage(driver);
				//verify home page loaded(the left top corner logo is displayed)
				assertTrue(homePage.logo.isDisplayed());
				//verify the Current URL is "https://4stay.com/"
				assertEquals(driver.getCurrentUrl(),"https://fourstay-staging.herokuapp.com/");
				//verify the Home page title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(homePage.isAt());
				System.out.println("Step 1 is done");
		
		
		//Step 2
		//Verify email address and password fields are displayed
		homePage.loginLink.click();
		BrowserUtils.waitForVisibility(loginPage.user_email, 1);
		assertTrue(loginPage.user_email.isDisplayed(),"email field was not displayed!");
		assertTrue(loginPage.user_password.isDisplayed(),"password field was not displayed!");
		assertTrue(loginPage.loginWithFacebook.isDisplayed(),"Login with Facebook was not displayed!");
		assertTrue(loginPage.loginWithGoogle.isDisplayed(),"Login with Google was not displayed!");
		
		//Step 3
		//Enter user name
		loginPage.user_email.sendKeys(Configuration.getProperty("mailuser"));
		//Enter password
		loginPage.user_password.sendKeys(Configuration.getProperty("mailpass"));
		//click login button
		loginPage.login_btn.click();
		//wait for loginStatus text is displayed
		BrowserUtils.waitForVisibility(loginPage.login_status, 1);
		assertFalse(loginPage.login_status.getText().equals("Invalid email or password. Please try again."),
				"Login is not successfull! Invalid email or password. Please try again");
		//verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed(),"Home page logo is not displayed.");
		//verify pop-up text "Successfully authenticated." is displayed
		assertTrue(homePage.successful.getText().equals("Successfully authenticated."),"Login is not successful.");
		//verify Log out link is displayed
		assertTrue(homePage.logOut.isDisplayed(),"Login is not successfull!");
		
	}
	
	
	
}
