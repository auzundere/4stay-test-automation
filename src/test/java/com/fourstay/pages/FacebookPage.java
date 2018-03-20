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
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement email;//facebook Email or Phone textbox
	
	@FindBy(xpath="//input[@id='pass']")
	public WebElement pass;//facebook password textbox
	
	@FindBy(xpath="//input[@name='login']") 
	public WebElement u_0_0; //facebook login button
	
	@FindBy(xpath="//button[@name='__CONFIRM__']") 
	public WebElement continueAs; //facebook Continue as [First name of Facebook Account owner]
		
	@FindBy(xpath="//div[@class='fb_content clearfix']")
	public WebElement textInfo;
	
	public boolean isAt() {
		return driver.getTitle().equals("Facebook");
	}
}
