package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.fourstay.pages.DashboardPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS007 extends TestBaseClass{
	
	@Test 
	public void Test7() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
		HomePage homePage = new HomePage(driver);
		//verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
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
		//Click "Continue with Email"  button
		signUpPage.emailButton.click();
		//verify we are at the Email Sign Up page
		//verify the current URL is "https://4stay.com/sign-up#!/basic-information"
		assertTrue(driver.getCurrentUrl()
				.equals("https://4stay.com/sign-up#!/basic-information"));
		//Verify "First name*" textbox is displayed
		assertTrue(signUpPage.firstName.isDisplayed());
		//Verify "First name*" textbox is displayed
		assertTrue(signUpPage.lastName.isDisplayed());
		//Verify "Email address*" textbox is displayed
		assertTrue(signUpPage.emailAddess.isDisplayed());
		//Verify "New password:" text is displayed
		assertTrue(signUpPage.password.isDisplayed());
		
		//Step 5
		//Fill aout the fields
		String email = BrowserUtils.generateEmail().toLowerCase();
		signUpPage.firstName.sendKeys(Configuration.getProperty("firstname"));
		signUpPage.lastName.sendKeys(Configuration.getProperty("lastname"));
		signUpPage.emailAddess.sendKeys(email);
		signUpPage.password.sendKeys(Configuration.getProperty("password"));
		signUpPage.signUpButton.click();
		
		try {
		//verify "I want to be a" text is displayed
		assertTrue(signUpPage.h5IwantToBe.isDisplayed());
		}catch(AssertionError e) {
			//verify home page loaded(the left top corner logo is displayed)
			assertTrue(homePage.logo.isDisplayed());
			//verify pop-up text "Successfully authenticated." is displayed
			assertTrue(homePage.successful.getText().equals("Successfully authenticated."));
			//verify "Log Out" text is appeared
			assertTrue(homePage.logOut.isDisplayed());
			System.out.println("Test Case FS007 is passed");
			return;
		}
		//verify "Host" button is displayed
		//BrowserUtils.waitForVisibility(signUpPage.hostButton, 5);
		assertTrue(signUpPage.hostButton.isDisplayed());
		
		//Step 6
		//verify "Guest" button is displayed
		assertTrue(signUpPage.guestButton.isDisplayed());
		//click guest Button
		signUpPage.hostButton.click();
		//click Next Button
		signUpPage.nextButton.click();
		//verify "Change profile image" button is displayed
		assertTrue(signUpPage.changeProfileImageButton.isDisplayed());
		
		//Step 7
		
		signUpPage.phone.clear();
		signUpPage.phone.sendKeys("2011234567");
		//enter something about yourself
		signUpPage.about_me.clear();
		signUpPage.about_me.sendKeys("I am SDET and I have 7 years of experience in Test Automation.");
		//enter birth year
		signUpPage.dob.clear();
		signUpPage.dob.sendKeys("1974");
		//click save.
		signUpPage.saveButton.click();
		//verify home page loaded(the left top corner logo is displayed)
		assertTrue(homePage.logo.isDisplayed());
		DashboardPage dashboardPage = new DashboardPage(driver);
		//click to Private Room
		dashboardPage.privateRoom.click();
		//click NEXT button
		dashboardPage.nextButton.click();
		//click House
		dashboardPage.house.click();
		//click + to make 2 bedrooms
		dashboardPage.plusBedroomButton.click();
		dashboardPage.plusBathroomButton.click();
		//click female
		dashboardPage.female.click();
		//click NEXT
		dashboardPage.nextButton.click();
		//select 3 amentities
		clickElements(dashboardPage.amentities.size(), 3, dashboardPage.amentities,0);
		dashboardPage.nextButton.click();
		Actions actions = new Actions(driver);
		dashboardPage.address.sendKeys("1234 North Lamar Boulevard");
		Thread.sleep(300);
		actions.sendKeys(dashboardPage.address,Keys.DOWN).perform();
		actions.sendKeys(dashboardPage.address,Keys.ENTER).perform();
		Thread.sleep(300);
		dashboardPage.metro.sendKeys("Metro");
		Thread.sleep(300);
		actions.sendKeys(dashboardPage.metro,Keys.DOWN).perform();
		actions.sendKeys(dashboardPage.metro,Keys.ENTER).perform();
		//click NEXT
		dashboardPage.nextButton.click();
		//Choose one of the bathroom type 1. Private, 2. Shared
		Thread.sleep(1000);
		//BrowserUtils.waitForClickablility(dashboardPage.bathroomType.get(1), 3);
		Random rand = new Random();
		dashboardPage.bathroomType.get(rand.nextInt(1)).click();
		//Click to incrase number of bed in the room
		dashboardPage.plusRoomBedButton.click();
		//click NEXT
		dashboardPage.nextButton.click();
		BrowserUtils.waitForVisibility(dashboardPage.foodDietery.get(3), 2);
		//assertTrue(dashboardPage.foodDietery.get(3).isDisplayed());
		clickElements(dashboardPage.foodDietery.size(), 3, dashboardPage.foodDietery, 1);
		
		BrowserUtils.waitForVisibility(dashboardPage.roomFeatures.get(15), 2);
		clickElements(dashboardPage.roomFeatures.size(), 3, dashboardPage.roomFeatures, 0);	
		//click NEXT
		dashboardPage.nextButton.click();
		dashboardPage.mainStayTitle.sendKeys(dashboardPage.address.getAttribute("value"));
		dashboardPage.mainStayDescription.sendKeys("Perfect Home to live close to UT...");
		dashboardPage.availableDateFrom.click();
		String idx1 = (rand.nextInt(2)+5) +"";
		String idx2 = (rand.nextInt(7)+1) +"";
		driver.findElement(By.xpath("(//div[@class='calendar-table']//tbody/tr["+idx1+"]/td["+idx2+"])[1]")).click();
		dashboardPage.availableDateTo.click();
		int count = 0;
		while(count<8){
			//Thread.sleep(1000);
			dashboardPage.calendarRightNextMonthArrow.click();
			count++;
		}
		driver.findElement(By.xpath("(//div[@class='calendar-table']//tbody/tr["+idx1+"]/td["+idx2+"])[3]")).click();
		//click NEXT
		dashboardPage.nextButton.click();
		//Enter rent per month between $900 and $2500
		dashboardPage.pricePerMonth.sendKeys((rand.nextInt(25)+9)*100+"");
		//Enter security deposit up to $500
		dashboardPage.securityDeposit.sendKeys((rand.nextInt(10))*50+"");
		//Select minimum stay in month
		//dashboardPage.minimumStay.get(rand.nextInt(dashboardPage.minimumStay.size()-1)+1);
		//Thread.sleep(500);
		//dashboardPage.saveButton.click();
	}
	
	public static void clickElements(int totalSize, int numberofElementSelect, List<WebElement> element, int startIndex) {
		Random rand = new Random();
		List<Integer> num = new ArrayList<>();
		for(int i=0;i<totalSize;i++) num.add(i);
		for(int i= startIndex; i<numberofElementSelect; i++) {
			int index = rand.nextInt(num.size()-1);
			int r = num.get(index)+1;
			chooseBlindspot(element.get(r));
			num.remove(index);
		}	
	}
	
	public static void chooseBlindspot(WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor)driver; 
		jse.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
	}
}
