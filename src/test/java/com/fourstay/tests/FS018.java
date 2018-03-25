package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.HostPage;
import com.fourstay.pages.LoginPage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS018  extends TestBaseClass{
	
	@Test 
	public void test() {
		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		SignUpPage signUpPage= new SignUpPage(driver);

		//Step 1
				HomePage homePage = new HomePage(driver);
				assertEquals(driver.getCurrentUrl(),"https://fourstay-staging.herokuapp.com/");
				assertTrue(homePage.isAt());
		//Step 2		
				homePage.loginLink.click();
				
				BrowserUtils.waitForVisibility(loginPage.user_email, 1);
				assertTrue(loginPage.user_email.isDisplayed(),"email field was not displayed!");
				assertTrue(loginPage.user_password.isDisplayed(),"password field was not displayed!");
				assertTrue(loginPage.loginWithFacebook.isDisplayed(),"Login with Facebook was not displayed!");
				assertTrue(loginPage.loginWithGoogle.isDisplayed(),"Login with Google was not displayed!");
		//step 3
				
				loginPage.user_email.sendKeys(Configuration.getProperty("mailuserhost"));
				loginPage.user_password.sendKeys(Configuration.getProperty("mailpasshost"));
				loginPage.login_btn.click();
			
				// step 4,5,6,7
				homePage.listYourStay.click();
				HostPage hostPage = new HostPage(driver);
				Assert.assertTrue(driver.getCurrentUrl().equals("https://4stay.com/dashboard/stays/new"), "check URL");
				assertTrue(hostPage.privateRoom.isDisplayed());
				hostPage.privateRoom.click();
				assertTrue(hostPage.sharedRoom.isDisplayed());

				hostPage.sharedRoom.click();
				assertTrue(hostPage.entirePlace.isDisplayed());

				
			
		
				
				
		
}
}