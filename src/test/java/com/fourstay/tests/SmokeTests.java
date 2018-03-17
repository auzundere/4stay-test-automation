package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.GooglePage1;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class SmokeTests extends TestBaseClass {

	@Test
	public void test() throws InterruptedException {

		driver.get(Configuration.getProperty("url"));

		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.logo.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homePage.isAt());

		// Step 2
		homePage.signUp.click();
		SignUpPage signUpPage = new SignUpPage(driver);
		assertTrue(signUpPage.loginText.isDisplayed());
		assertTrue(signUpPage.moreOptions.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/onboarding");
		assertTrue(signUpPage.isAt());

		// Step 3
		signUpPage.moreOptions.click();
		assertEquals(signUpPage.facebookButton.getText(), "Continue with Facebook");
		assertEquals(signUpPage.googleButton.getText(), "Continue with Google");
		assertEquals(signUpPage.emailButton.getText(), "Continue with Email");

		// Step 4
		signUpPage.facebookButton.click();
		FacebookPage facebookPage = new FacebookPage(driver);
		assertTrue(facebookPage.isAt());
		assertTrue(facebookPage.emailOrPhoneLabel.isDisplayed());
		assertTrue(facebookPage.passwordLabel.isDisplayed());

		// step 5

		facebookPage.email.sendKeys(Configuration.getProperty("facebookuser"));
		facebookPage.pass.sendKeys(Configuration.getProperty("facebookpass"));
		facebookPage.u_0_0.click();
		driver.get("https://4stay.com/");
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.logOut.isDisplayed());
		
		
		//step 6
		
		assertTrue(homePage.searchBox.isDisplayed());
		homePage.searchBox.sendKeys(("Seattle WA,USA")+Keys.ARROW_DOWN,Keys.ENTER);
		BrowserUtils.waitForVisibility(homePage.searchBox, 4);
		//homePage.searchBox.sendKeys(("Seattle"));
		Actions actions = new Actions(driver);
		actions.sendKeys(homePage.searchBox, "Seattle").perform();
		//
		//BrowserUtils.waitForVisibility(homePage.searchBox, 4);
		
		actions.click(homePage.searchBox).perform();
		actions.sendKeys(homePage.searchBox,Keys.DOWN).perform();
		actions.sendKeys(homePage.searchBox,Keys.ENTER).perform();
		actions.click(homePage.searchButton).perform();
		Thread.sleep(500);
		homePage.searchBox.sendKeys(Keys.ENTER);
	//	System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().contains("Seattle"));

		

	}

}
