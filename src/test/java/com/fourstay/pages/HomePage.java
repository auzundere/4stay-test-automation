package com.fourstay.pages;

import java.util.List;

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

	@FindBy(xpath = "//div[@id='top-navbar']/ul/li[3]/a")
	// 1
	public WebElement signUp;

	@FindBy(xpath = "//div[@class='logo']/a/img")
	public WebElement logo;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement successful;

	@FindBy(xpath = "//a[@rel='nofollow']")
	public WebElement logOut;

	public boolean isAt() {
		return driver.getTitle().equals("Room rental, roommate finder, off-campus housing, homestay | 4stay");

	}

	// -----------------
	// List of elements (text with style h2)
	@FindBy(tagName = "h2")
	public List<WebElement> style_d2_texts;

	// link "continue with Facebook"
	@FindBy(xpath = "//i[@class='fa fa-2x fa-facebook mr-2']")
	public WebElement continueWithFacebook_link;

	// button "Continue with Facebook",
	@FindBy(xpath = "//a[@class='btn facebook-btn w-100 m-0 mb-3']")
	public WebElement continueWithFacebook_button;

	// button "Continue with Google", orange
	@FindBy(xpath = "//a[@class='btn google-btn w-100 m-0 mb-3']")
	public WebElement continueWithGoogle_button;

	// button "Continue with Email", lilac
	@FindBy(xpath = "//div[@class='btn email-btn w-100 m-0 mb-3']")
	public WebElement continueWithEmail_button;
	
	@FindBy(xpath="//input[@class='search-input ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn search-btn']")
	public WebElement searchButton;
	

}
