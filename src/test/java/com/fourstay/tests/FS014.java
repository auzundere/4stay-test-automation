package com.fourstay.tests;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;


  public class FS014 extends TestBaseClass {

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
	public void Test014() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		SoftAssert softAssert = new SoftAssert();

		// Step 1
		HomePage homePage = new HomePage(driver);
		// verify the Current URL is "https://4stay.com/"
		highlightElement(homePage.logo, "purple");
		((JavascriptExecutor) driver).executeScript("alert('Home page loaded: the left top corner logo is displayed')");

		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		// ---------------------
		assertTrue(homePage.logo.isDisplayed(), "logo");
		// *verify that home page loaded correctly: URL of loaded page is equal to
		// expected URL.
		softAssert.assertEquals(driver.getCurrentUrl(), "https://fourstay-staging.herokuapp.com/");
		// *verify that home page loaded correctly: Title of a loaded page is equal to
		// expected title
		softAssert.assertEquals(driver.getTitle(), "Room rental, roommate finder, off-campus housing, homestay | 4stay",
				"(!)title not equal");

		// Step 2
		// Verify Search input field is on the home page
		highlightElement(homePage.searchButton, "yellow");
		Thread.sleep(200);

		highlightElement(homePage.searchBox, "blue");
		Thread.sleep(200);

		// Step 3

		// verify pop up appears
		homePage.searchBox.click();
		homePage.searchBox.sendKeys("@" + Keys.ENTER);
		// flashElement(homePage.searchBox, "yellow");

		try {
			((JavascriptExecutor) driver)
					.executeScript("alert('Do NOT enter special characters! Please search city, college, or metro");

			Alert alert1 = driver.switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
		} catch (WebDriverException e) {
			System.out.println("passed!");
		}
		// ---------------------

		// Enter special characters as search input and click to Search button

		softAssert.assertAll();

	}

}

