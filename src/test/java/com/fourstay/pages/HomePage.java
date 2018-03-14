package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Hello Everyone -Handan!
	@FindBy(xpath="//div[@id='top-navbar']/ul/li[3]/a")
	//1
	public WebElement signUp;
	
}
