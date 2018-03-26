package com.fourstay.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.HostPage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS020 extends TestBaseClass {

	@Test
	public void test() {
		driver.get(Configuration.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);

		homePage.loginLink.click();
		BrowserUtils.waitForVisibility(loginPage.user_email, 1);
		loginPage.user_email.sendKeys(Configuration.getProperty("mailuser"));
		loginPage.user_password.sendKeys(Configuration.getProperty("mailpass"));
		loginPage.login_btn.click();
		homePage.listYourStay.click();
		HostPage hostPage = new HostPage(driver);
		hostPage.privateRoom.click();
		hostPage.buttonNext.click();
		hostPage.entirePlace.click();
		hostPage.house.click();
		BrowserUtils.waitForPageToLoad(1);

		hostPage.plusBadroom.click();
		hostPage.plusBadroom.click();

		Actions actions = new Actions(driver);
		actions.moveToElement(hostPage.plusBathroom).perform();
		BrowserUtils.waitForClickablility(hostPage.plusBathroom, 2);
		hostPage.plusBathroom.click();

		hostPage.femaleIcon.click();
		hostPage.buttonNext.click();
		assertTrue(hostPage.wifi.isDisplayed());
		hostPage.wifi.click();
		assertTrue(hostPage.wifi.isEnabled());

		assertTrue(hostPage.catsOkay.isDisplayed());
		hostPage.catsOkay.click();
		assertTrue(hostPage.catsOkay.isEnabled());
	}
}