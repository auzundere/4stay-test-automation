package com.fourstay.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.HostPage;
import com.fourstay.pages.LoginPage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS019 extends TestBaseClass {
	
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
		driver.manage().window().maximize();


		SoftAssert softAssert = new SoftAssert();

		// --Step 1--
		HomePage homePage = new HomePage(driver);
		
		
		
		homePage.loginLink.click();
		BrowserUtils.waitForPageToLoad(5);
		
		LoginPage loginPage = new LoginPage(driver);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(loginPage.loginWithFacebook).perform();
		BrowserUtils.waitForClickablility(loginPage.loginWithFacebook, 2);
		loginPage.loginWithFacebook.click();
		BrowserUtils.waitForPageToLoad(5);
		
		FacebookPage facebookPage = new FacebookPage(driver);
		
		facebookPage.email.sendKeys("al57kot2000@yahoo.com");
		facebookPage.pass.sendKeys("Samarkand57");
		facebookPage.u_0_0.click();
		BrowserUtils.waitForPageToLoad(1);
		
		homePage.listYourStay.click();
		
		HostPage hostPage = new HostPage(driver);
		softAssert.assertTrue(driver.getCurrentUrl().equals("https://4stay.com/dashboard/stays/new"), "check URL");
		
		hostPage.privateRoom.click();
		
		//if round marker (i.e. marker at StayType) is selected, it's class = "fa fa-2x completed fa-check-circle" 
		//if round marker (i.e. marker at StayType) is NOT selected, it's class =
		//-------------
		//if label text is bold, its css.font-weight = 430.25
		//if label text is NOT bold, its css.font-weight = 400
		//-------------
		System.out.println("***"+hostPage.stayTypeMarker.getAttribute("class"));
		
		// validate that marker for element StayType is selected
		softAssert.assertTrue(hostPage.stayTypeMarker.getAttribute("class").equals("fa fa-2x completed fa-check-circle"), "marker is not selected");
		
		System.out.println("font = "+hostPage.stayTypeLabel.getCssValue("font-weight"));
		System.out.println("font = "+hostPage.propertyDetailsLabel.getCssValue("font-weight"));
		
		// verify that text style for label StayType is bold
		double textFont = Double.parseDouble(hostPage.stayTypeLabel.getCssValue("font-weight"));
		softAssert.assertTrue(textFont > 400, "text is not bold");
		
		hostPage.buttonNext.click();
		BrowserUtils.waitForPageToLoad(5);
		
		// verify that number of icons on Host Page (stay type)= 11
		System.out.println("number of icons"+hostPage.hostIcons.size());
		softAssert.assertTrue((hostPage.hostIcons.size() == 11), "number of icons not equal to 11");
		
		Thread.sleep(600);
		
		//click on 'icon house'
		hostPage.house.click();
		BrowserUtils.waitForPageToLoad(1);
		
		//add 3 bedrooms
		hostPage.plusBadroom.click();
		hostPage.plusBadroom.click();
		
		
		actions.moveToElement(hostPage.plusBathroom).perform();
		BrowserUtils.waitForClickablility(hostPage.plusBathroom, 2);
		//add 2 bathrooms
		hostPage.plusBathroom.click();
		
		//click on female icon
		hostPage.femaleIcon.click();
				
		softAssert.assertAll();
}
}