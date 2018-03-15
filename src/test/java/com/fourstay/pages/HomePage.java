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
	
	@FindBy(xpath="//div[@class='logo']/a/img")
	public WebElement logo;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	public WebElement successful;
	
	@FindBy(xpath="//a[@rel='nofollow']")
	public WebElement logOut;
	
	public boolean isAt() {
		return driver.getTitle().equals("Room rental, roommate finder, off-campus housing, homestay | 4stay");
	}
	
}
