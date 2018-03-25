package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.LoginPage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS017 extends TestBaseClass{
	@Test 
	public void Test017() {
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
				homePage.searchBox.sendKeys("St Louis");
			
				//Select dropDownMenu = new Select(driver.findElement(By.xpath("//input[@placeholder='Where are you going? (type your city, college, or metro)']")));
				//dropDownMenu.selectByVisibleText("St. Louis, MO, USA");

				
	
	}
}