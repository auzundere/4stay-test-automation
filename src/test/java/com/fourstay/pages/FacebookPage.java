package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
	private WebDriver driver;

	public FacebookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='email_container']/div/label")
	public WebElement emailOrPhoneLabel;
	
	@FindBy(xpath="//input[@type='password']/../label")
	public WebElement passwordLabel;
	
	public WebElement email;//facebook Email or Phone textbox
	public WebElement pass;//facebook password textbox
	public WebElement u_0_0; //facebook login button
	
//	@FindBy(xpath="//button[@class='_42ft _4jy0 layerConfirm _1fm0 _51_n autofocus _4jy3 _4jy1 selected _51sy']")
//	public WebElement continueAs;
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Facebook");
	}
}
