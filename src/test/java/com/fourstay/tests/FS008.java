package com.fourstay.tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS008 extends TestBaseClass {

	public static WebElement highlightElement(WebElement elem) {

		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}

	public static WebElement highlightElement(WebElement elem, String style) {

		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid " + style + "'", elem);
		}
		return elem;
	}

	public static WebElement flashElement(WebElement elem, String color) {
		// change color of the background of element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='" + color + "'", elem);
		}
		return elem;
	}

	@Test
	public void Test8() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		SoftAssert softAssert = new SoftAssert();

		// --Step 1--
		HomePage homePage = new HomePage(driver);

		// verify home page loaded(the left top corner logo is displayed)
		// ---------------------
		highlightElement(homePage.logo, "red");
		((JavascriptExecutor) driver).executeScript("alert('Home page loaded: the left top corner logo is displayed')");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		// ---------------------
		assertTrue(homePage.logo.isDisplayed());
		// *verify that home page loaded correctly: URL of loaded page is equal to
		// expected URL.
		softAssert.assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// *verify that home page loaded correctly: Title of a loaded page is equal to
		// expected title
		softAssert.assertEquals(driver.getTitle(), "Room rental, roommate finder, off-campus housing, homestay | 4stay",
				"(!)title not equal");

		// *verify that home page loaded correctly: text "Rent medium to long-term
		// furnished stays today!" is on the page
		List<String> d2_titles_str = new ArrayList<>();

		for (WebElement d2 : homePage.style_d2_texts) {
			// System.out.println("** "+d2.getText());
			if (!d2.getText().isEmpty()) {
				d2_titles_str.add(d2.getText());
			}
		}
		// System.out.println("++ "+d2_titles_str.contains("Rent medium to long-term
		// furnished stays today!"));
		softAssert.assertTrue((d2_titles_str.contains("Rent medium to long-term furnished stays today!")),
				"Text'Rent medium to long-term furnished stays today!'  does not find on the page");

		// --Step 2-- Click the SIGN UP to navigate to Sign-Up page.
		homePage.signUp.click();

		SignUpPage signUpPage = new SignUpPage(driver);

		// *verify that page loaded correctly: URL of loaded page is equal to expected
		// URL.
		softAssert.assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/onboarding",
				"irl is not eqial to 'https://fourstay-staging.herokuapp.com/sign-up#!/onboarding'");

		// *verify that page loaded correctly: Title of a loaded page is equal to
		// expected title
		softAssert.assertEquals(driver.getTitle(),
				"Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay", "(!)title1 not equal");

		// Step 3. Click "More Options" button
		BrowserUtils.waitForClickablility(signUpPage.moreOptions, 5);
		signUpPage.moreOptions.click();

		// Thread.sleep(500);

		// *verify that page loaded correctly: URL of loaded page is equal to expected
		// URL
		softAssert.assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/sign-up#!/more-options",
				"irl is not eqial to 'https://fourstay-staging.herokuapp.com/sign-up#!/more-options'");

		/*
		 * Verify that the next buttons appears: 1) Continue with Facebook 2) Continue
		 * with Google 3) Continue with Email
		 */

		// ---------------------
		highlightElement(signUpPage.facebookButton, "red");
		highlightElement(signUpPage.googleButton, "blue");
		highlightElement(signUpPage.emailButton, "blue");
		Thread.sleep(200);

		((JavascriptExecutor) driver).executeScript(
				"alert('Buttons appears: 1) Continue with Facebook 2) Continue 3) Continue with Email')");

		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		// ---------------------

		List<WebElement> fb = driver.findElements(By.xpath("//a[@class='btn facebook-btn w-100 m-0 mb-3']"));
		softAssert.assertTrue(fb.size() > 0, "button 'Continue with Facebook' is not loaded");

		List<WebElement> google = driver.findElements(By.xpath("//a[@class='btn google-btn w-100 m-0 mb-3']"));
		softAssert.assertTrue(google.size() > 0, "button 'Continue with Google' is not loaded");

		List<WebElement> email = driver.findElements(By.xpath("//div[@class='btn email-btn w-100 m-0 mb-3']"));
		softAssert.assertTrue(email.size() > 0, "button 'Continue with Email' is not loaded");

		List<WebElement> nothing = driver.findElements(By.xpath("//NOdiv[@class='btn email-btn w-100 m-0 mb-3']"));
		softAssert.assertTrue((nothing.size() == 0), "just to check that this element not loaded");

		// Step 4. Click "Continue with Email button. Verify that the registration page
		// appears

		signUpPage.emailButton.click();
		BrowserUtils.waitForPageToLoad(2);

		softAssert.assertTrue(driver.getCurrentUrl().equals("https://fourstay-staging.herokuapp.com/sign-up#!/basic-information"));
		// ------------------
		((JavascriptExecutor) driver)
				.executeScript("alert('URL of this page is equal to *https://fourstay-staging.herokuapp.com/sign-up#!/basic-information*')");

		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		// -------------------

		// Step 5. Fill up the input fields. Fill up the input fields.

		signUpPage.firstName.sendKeys("TeslaSpace");
		signUpPage.lastName.sendKeys("BestModel");
		signUpPage.emailAddess.sendKeys(BrowserUtils.generateEmail());
		signUpPage.password.sendKeys("Tesla!");

		Thread.sleep(1000);
		// ------------------
		((JavascriptExecutor) driver)
				.executeScript("alert('We use Email - generator to generate new Email address for this Page. *')");

		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		// -------------------
		flashElement(signUpPage.emailStr, "yellow");
		Thread.sleep(2000);

		signUpPage.signUpButton.click();
		BrowserUtils.waitForPageToLoad(2);

		// Verify that the page with the following options appears: I want to become a
		// Host or Guest"

		try {
			// **assertTrue(regPage.iWantToBe.isDisplayed(), "I want to be is not
			// displayed");
			assertTrue(signUpPage.h5IwantToBe.isDisplayed(), "I want to be is not displayed");
		} catch (AssertionError e) {
			System.out.println("Account already created and there is no need to have a negative test.");
			return;
		}
		// **softAssert.assertTrue(regPage.guestButton.isDisplayed(), "guestButton is
		// not displayed");
		softAssert.assertTrue(signUpPage.guestButton.isDisplayed(), "guestButton is not displayed");
		// **softAssert.assertTrue(regPage.hostButton.isDisplayed(), "guestButton is not
		// displayed");
		softAssert.assertTrue(signUpPage.hostButton.isDisplayed(), "guestButton is not displayed");
		// Step 6. 1) Click Guest button 2) Click Next button

		// ---------------------
		highlightElement(signUpPage.guestButton, "blue");
		highlightElement(signUpPage.hostButton, "red");
		Thread.sleep(200);

		((JavascriptExecutor) driver).executeScript("alert('Options *HOST*  and *GUEST* are appeared on Page.')");

		Alert alert4 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		// ---------------------

		// Step 6. 1) Click Guest button. Click Next button

		signUpPage.guestButton.click();
		signUpPage.nextButton.click();
		BrowserUtils.waitForPageToLoad(2);

		// **regPage.emailAddress.sendKeys("");
		signUpPage.emailFacebook.sendKeys("");
		BrowserUtils.waitForClickablility(signUpPage.occupationOrSchool, 5);
		// Thread.sleep(500);
		// **regPage.occupation.sendKeys("Bysiness Analyst");
		signUpPage.occupationOrSchool.sendKeys("Bysiness Analyst");
		signUpPage.phone.sendKeys("3175552216");
		signUpPage.about_me.sendKeys("Hello All! So nice day is today!");
		signUpPage.dob.sendKeys("2000");

		// ---------------------
		flashElement(signUpPage.emailFacebook, "yellow");
		flashElement(signUpPage.occupationOrSchool, "yellow");
		flashElement(signUpPage.phone, "yellow");
		flashElement(signUpPage.about_me, "#FFB6C1");
		flashElement(signUpPage.dob, "yellow");
		Thread.sleep(200);

		((JavascriptExecutor) driver)
				.executeScript("alert('WE just entered all required information AND ready to click on SAVE!')");

		Alert alert5 = driver.switchTo().alert();
		Thread.sleep(4000);
		alert.accept();
		// ---------------------

		signUpPage.saveButton.click();
		BrowserUtils.waitForPageToLoad(2);

		softAssert.assertTrue(driver.getCurrentUrl().equals("https://fourstay-staging.herokuapp.com/"));

		softAssert.assertTrue(homePage.label_h2.getText().equals("Rent medium to long-term furnished stays today!"));
		softAssert.assertTrue(homePage.logOut.isDisplayed());

		// ---------------------
		flashElement(homePage.label_h2, "#C71585");
		highlightElement(homePage.label_h2, "blue");
		highlightElement(homePage.logOut, "red");
		

		((JavascriptExecutor) driver)
				.executeScript("alert('We just got the HOME Page as registered GUEST. We have to verify that this text and LOG OUT link are displayed. All done! SignUp functionality for guest is working properly!')");

		Alert alert6 = driver.switchTo().alert();
		Thread.sleep(4000);
		alert.accept();
		// ---------------------

		softAssert.assertAll();
	}

}
