package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	private WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="identifierId")
	public WebElement email;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public WebElement nextEmail;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Next')]")
	public WebElement nextPassword;
	
	@FindBy(xpath="(//div[@class='vdE7Oc f3GIQ'])[2]")
	public WebElement UseAnotherAccount;
	
	@FindBy(xpath="(//input[@class='whsOnd zHQkBf'])[1]")
	public WebElement EmailOrPhone;
	
	@FindBy(xpath="(//span[@class='RveJvd snByac'])[2]")
	public WebElement NextButton;
	
	@FindBy(xpath="(//input[@class='whsOnd zHQkBf'])[1]")
	public WebElement Password;
	
	public boolean isAt() {
		return driver.getTitle().equals("Sign in - Google Accounts");
	}
	
	
}
