package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS016 extends TestBaseClass{
	
	@Test 
	public void Test016() {
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
				HomePage homePage = new HomePage(driver);
				//verify the Current URL is "https://4stay.com/"
				assertEquals(driver.getCurrentUrl(),"https://4stay.com/");
				//verify the Home page title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(homePage.isAt());
				
				//Step 2
				//Verify Search input field is on the home page
				assertTrue(homePage.searchBox.isDisplayed());
				
				//Step 3
				//Leave the search field empty and click to Search button 
				homePage.searchButton.click();
				//verify pop up appears
				assertTrue(homePage.popUpPleaseEnter.isDisplayed());
				//verify "Please type your city, college, or metro" is displayed
				String actual=homePage.popUpPleaseEnter.getText();
				assertEquals(actual,"Please type your city, college, or metro");
				

}
}