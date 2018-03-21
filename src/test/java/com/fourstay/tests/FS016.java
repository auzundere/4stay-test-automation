package com.fourstay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS016 extends TestBaseClass{
	
	@Test 
	public void Test16() {
		driver.get(Configuration.getProperty("url"));
		
		//Step 1
				HomePage homePage = new HomePage(driver);
				//verify the Current URL is "https://4stay.com/"
				assertEquals(driver.getCurrentUrl(),"https://4stay.com/");
				//verify the Home page title is "Room rental, roommate finder, off-campus housing, homestay | 4stay"
				assertTrue(homePage.isAt());
				
				//Step 2
	

}
}