package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user_email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='user_password']")
	public WebElement password;
	
	@FindBy(xpath="//a[.='Login with Facebook']")
	public WebElement loginWithFacebook;
	
	@FindBy(xpath="//a[.='Login with Google']")
	public WebElement loginWithGoogle;
	
	
	
}
