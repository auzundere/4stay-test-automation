package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class SmokeTests extends TestBaseClass {

	@Test
	public void test() throws InterruptedException {

		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		assertTrue(homePage.logo.isDisplayed());
		assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
		assertTrue(homePage.isAt());

		homePage.loginLink.click();
		BrowserUtils.waitForVisibility(loginPage.loginWithGoogle, 1);
		assertTrue(loginPage.user_email.getAttribute("placeholder").equals("Email address"));
		assertTrue(loginPage.user_password.getAttribute("placeholder").equals("Password"));
		assertTrue(loginPage.loginWithFacebook.isDisplayed());
		assertTrue(loginPage.loginWithGoogle.isDisplayed());

		loginPage.loginWithFacebook.click();
		FacebookPage facebookPage = new FacebookPage(driver);
		assertTrue(facebookPage.isAt());
		assertTrue(facebookPage.emailOrPhoneLabel.isDisplayed());
		assertTrue(facebookPage.passwordLabel.isDisplayed());

		facebookPage.email.sendKeys(Configuration.getProperty("facebookuser"));
		facebookPage.pass.sendKeys(Configuration.getProperty("facebookpass"));
		facebookPage.u_0_0.click();
		Thread.sleep(500);
		try {
			assertTrue(facebookPage.continueAs.isDisplayed());
			facebookPage.continueAs.click();
		} catch (NoSuchElementException e) {
			System.out.println("Transferring to home page...");
		}

		BrowserUtils.waitForVisibility(homePage.logo, 2);
		// verify pop-up text "Successfully authenticated." is displayed
		assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.logOut.isDisplayed());

		assertTrue(homePage.searchBox.isDisplayed());

		// homePage.searchBox.sendKeys(("Metro")+Keys.ARROW_DOWN,Keys.ENTER);
		BrowserUtils.waitForVisibility(homePage.searchBox, 4);
		// homePage.searchBox.sendKeys(("Seattle"));
		Actions actions = new Actions(driver);
		actions.sendKeys(homePage.searchBox, "Metro").perform();

		// BrowserUtils.waitForVisibility(homePage.searchBox, 4);
		Thread.sleep(300);
		BrowserUtils.waitForClickablility(homePage.searchBox, 2);
		actions.click(homePage.searchBox).perform();

		actions.sendKeys(homePage.searchBox, Keys.DOWN).perform();
		actions.sendKeys(homePage.searchBox, Keys.DOWN).perform();

		actions.sendKeys(homePage.searchBox, Keys.ENTER).perform();
		Thread.sleep(200);
		homePage.searchButton.click();

		Thread.sleep(5000);

		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		assertTrue(searchResultsPage.maps.isDisplayed());
		// System.out.println(driver.getTitle());
		String actual = searchResultsPage.searckBoxOnResultsPage.getAttribute("value");
		// System.out.println(actual);
		assertTrue(driver.getTitle().contains(actual));
	}

}
