package com.fourstay.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBaseClass{
	
	protected static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void setUp(@Optional String browser) {
		driver=Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().window(driver.getWindowHandle());
		//driver.manage().window().fullscreen();
		driver.get(Configuration.getProperty("url"));
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		//driver.quit();
		//Thread.sleep(500);
		Driver.quit();
	}	
	public static String getOnlyDigits(String str) {
		String result ="";
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				result+=str.charAt(i)+"";
			}
		}
		
		return result;
	}
	public static double convertToDoubleBackToString(String price) {
		price = price.replace("$", "");
		return Double.parseDouble(price);
	}
	
}
