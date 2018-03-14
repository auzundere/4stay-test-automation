package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	private WebDriver driver;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn facebook-btn w-100 m-0 mb-3']")
	public WebElement facebookSignUpButton;
	
	public WebElement email;//facebook Email or Phone textbox
	public WebElement pass;//facebook password textbox
	public WebElement u_0_0; //facebook login button
}
