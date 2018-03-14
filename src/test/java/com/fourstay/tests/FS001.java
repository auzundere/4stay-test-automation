package com.fourstay.tests;

import org.testng.annotations.Test;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS001 extends TestBaseClass{
	
	@Test 
	public void Test1() {
		driver.get(Configuration.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		homePage.signUp.click();
		System.out.println("Sign Up Page");
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.facebookSignUpButton.click();
		signUpPage.email.sendKeys(Configuration.getProperty("facebookuser"));
		signUpPage.pass.sendKeys(Configuration.getProperty("facebookpass"));
		signUpPage.u_0_0.click();
	}
	
}
