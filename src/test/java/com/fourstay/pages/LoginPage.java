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
	
	public WebElement user_email;
	
	public WebElement user_password;
	
	@FindBy(xpath="//a[.='Login with Facebook']")
	public WebElement loginWithFacebook;
	
	@FindBy(xpath="//a[.='Login with Google']")
	public WebElement loginWithGoogle;
	
	public WebElement login_btn;
	
	public WebElement login_status;
	
	
	
	
}
