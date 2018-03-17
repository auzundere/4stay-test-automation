package com.fourstay.tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fourstay.pages.FacebookPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SignUpPage;
import com.fourstay.utilities.BrowserUtils;
import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS003 extends TestBaseClass{
	
	@Test 
	public void Test3() throws InterruptedException {
		driver.get(Configuration.getProperty("url"));
		SoftAssert softAssert = new SoftAssert();
		
		//--Step 1--
				HomePage homePage = new HomePage(driver);
				
				//*verify that home page loaded correctly: URL of loaded page is equal to expected URL.
				softAssert.assertEquals(driver.getCurrentUrl(), "https://4stay.com/");
				
				//*verify that home page loaded correctly: Title of a loaded page is equal to expected title
				softAssert.assertEquals(driver.getTitle(), "Room rental, roommate finder, off-campus housing, homestay | 4stay", "(!)title not equal");
				
				//*verify that home page loaded correctly: text "Rent medium to long-term furnished stays today!" is on the page
				List<String> d2_titles_str = new ArrayList<>();
				
				for (WebElement d2: homePage.style_d2_texts) {
					//System.out.println("** "+d2.getText());
					if(!d2.getText().isEmpty()) {
						d2_titles_str.add(d2.getText());
					}
				}
				//System.out.println("++ "+d2_titles_str.contains("Rent medium to long-term furnished stays today!"));
				softAssert.assertTrue((d2_titles_str.contains("Rent medium to long-term furnished stays today!")), 
						"Text'Rent medium to long-term furnished stays today!'  does not find on the page");
				
		//--Step 2-- Click the SIGN UP to navigate to Sign-Up page.
				homePage.signUp.click();
				
				SignUpPage signUpPage = new SignUpPage(driver);
				
				//*verify that page loaded correctly: URL of loaded page is equal to expected URL.
						softAssert.assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/onboarding",
								"irl is not eqial to '//https://4stay.com/sign-up#!/onboarding'");
						
				//*verify that page loaded correctly: Title of a loaded page is equal to expected title
						softAssert.assertEquals(driver.getTitle(), "Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay", 
								"(!)title1 not equal");
				
						
		//Step 3. Click "More Options" button 
						BrowserUtils.waitForClickablility(signUpPage.moreOptions, 5);
						signUpPage.moreOptions.click();
						
						//Thread.sleep(500);
						
								
				//*verify that page loaded correctly: URL of loaded page is equal to expected URL
						softAssert.assertEquals(driver.getCurrentUrl(), "https://4stay.com/sign-up#!/more-options",
								"irl is not eqial to 'https://4stay.com/sign-up#!/more-options'");
						
				/* Verify that the next buttons appears:
					1) Continue with Facebook
					2) Continue with Google
					3) Continue with Email	*/	
						
						List<WebElement> fb = driver.findElements(By.xpath("//a[@class='btn facebook-btn w-100 m-0 mb-3']"));
						softAssert.assertTrue(fb.size()>0, "button 'Continue with Facebook' is not loaded");
						
						List<WebElement> google = driver.findElements(By.xpath("//a[@class='btn google-btn w-100 m-0 mb-3']"));
						softAssert.assertTrue(google.size()>0, "button 'Continue with Google' is not loaded");
						
						List<WebElement> email = driver.findElements(By.xpath("//div[@class='btn email-btn w-100 m-0 mb-3']"));
						softAssert.assertTrue(email.size()>0, "button 'Continue with Email' is not loaded");
						
						List<WebElement> nothing = driver.findElements(By.xpath("//NOdiv[@class='btn email-btn w-100 m-0 mb-3']"));
						softAssert.assertTrue((nothing.size()==0), "just to check that this element not loaded");
						
		//Step 4.	Click "Continue with Facebook"  button			
						signUpPage.facebookButton.click();
						
						//* Verify that Facebook Log in page appears
						FacebookPage facebookPage = new FacebookPage(driver);
						
						//*verify the title of the page is "Facebook"
						softAssert.assertTrue(facebookPage.isAt());
						
						//* verify that text "Log in to use your Facebook account with 4stay" is displayed 
						softAssert.assertTrue(facebookPage.textInfo.getText().contains("Log in to use your Facebook account"));
						
		//Step 5.	1) Enter valid Facebook account information
//		          2) Click log in button		
						facebookPage.email.sendKeys(Configuration.getProperty("facebook003user"));
						facebookPage.pass.sendKeys(Configuration.getProperty("facebook003pass"));
						BrowserUtils.waitForClickablility(facebookPage.u_0_0, 3);
						//Thread.sleep(300);
						facebookPage.u_0_0.click();
						
						
						//Verify that the page with the following options appears:  I want to become a Host or Guest"
						
						//**RegistrationPage regPage = new RegistrationPage(driver);
						try {
							//**assertTrue(regPage.iWantToBe.isDisplayed(), "I want to be is not displayed");
							assertTrue(signUpPage.h5IwantToBe.isDisplayed(), "I want to be is not displayed");
						}catch(AssertionError e) {
							System.out.println("Account already created and there is no need to have a negative test.");
							return;
						}
						//**softAssert.assertTrue(regPage.guestButton.isDisplayed(), "guestButton is not displayed");
						softAssert.assertTrue(signUpPage.guestButton.isDisplayed(), "guestButton is not displayed");
						//**softAssert.assertTrue(regPage.hostButton.isDisplayed(), "guestButton is not displayed");
						softAssert.assertTrue(signUpPage.hostButton.isDisplayed(), "guestButton is not displayed");
//			Step 6.		1) Click Guest button    2) Click Next button	
						
						//**regPage.guestButton.click();
						signUpPage.guestButton.click();
						//**regPage.nextButton.click();
						signUpPage.nextButton.click();
						
						//Verify that the registration page appears
						
						List<WebElement> labelOccupation = driver.findElements(By.xpath("//label[contains(text(),'Occupation/School')]"));
						softAssert.assertTrue((labelOccupation.size() > 0), "Element 'occupation' is not on page");
						
						List<WebElement> labelEAddrress = driver.findElements(By.xpath("//label[contains(text(),'Email address *')]"));
						softAssert.assertTrue((labelEAddrress.size() > 0), "Element 'e- mail address ' is not on page");
						
						
						
//		 	Step 7.		1) Fill up the input fields except for "Tell us about yourself" and "Year of birth"
//		              
						
						//**regPage.emailAddress.sendKeys("ivan.Tesla@gmail.com");
						signUpPage.emailAddess.sendKeys("");
						BrowserUtils.waitForClickablility(signUpPage.occupationOrSchool, 5);
						//Thread.sleep(500);
						//**regPage.occupation.sendKeys("Bysiness Analyst");
						signUpPage.occupationOrSchool.sendKeys("Bysiness Analyst");
						
						// title before clicking save button
						String titleBefore = driver.getTitle();
						// 2) Click Save button
						//**regPage.saveButton.click();
						signUpPage.saveButton.click();
						BrowserUtils.waitForClickablility(signUpPage.saveButton, 3);
						
						
						// title after clicking save button
						String titleAfter = driver.getTitle();
						
						softAssert.assertEquals(titleBefore, titleAfter, "button Savedoes not work properly");
						
	}
	
}
