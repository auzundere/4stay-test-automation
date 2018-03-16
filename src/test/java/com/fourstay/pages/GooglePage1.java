package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage1 {

	private WebDriver driver;

	public GooglePage1(WebDriver driver) {
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
	
	
	
}
