package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS017 extends TestBaseClass{
	@Test 
	public void Test017() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
	
				//Step 1
				HomePage homePage = new HomePage(driver);
				//verify the Current URL is "https://fourstay-staging.herokuapp.com/"
				assertEquals(driver.getCurrentUrl(),"https://fourstay-staging.herokuapp.com/");
				//verify the Home page title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(homePage.isAt());

				//Step 2
				//Verify search input field is on the homepage
				assertTrue(homePage.searchBox.isDisplayed());
				
				//Step 3
				//Enter City Name as serach input,Select on of the option from the resulted dropdown menu
				
				Actions actions = new Actions(driver);
				homePage.searchBox.sendKeys("St Louis");
				Thread.sleep(300);
				actions.sendKeys(homePage.searchBox,Keys.DOWN).perform();
				actions.sendKeys(homePage.searchBox,Keys.ENTER).perform();
				Thread.sleep(300);
				homePage.searchButton.click();
				assertEquals(driver.getCurrentUrl(),"https://fourstay-staging.herokuapp.com/advanced_search?lat=38.62700249999999&long=-90.1994042&place_title=St.%20Louis,%20MO,%20USA&move_in=2018-03-26&move_out=2018-09-25&number_of_beds=1");
	
	}
}