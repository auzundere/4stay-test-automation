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

	@FindBy(xpath="//a[@data-toggle='modal']")
	public WebElement loginLink;
	
	// Hello Everyone -Handan!
	@FindBy(xpath = "//div[@id='top-navbar']/ul/li[3]/a")
	// 1
	public WebElement signUp;

	@FindBy(xpath = "//div[@class='logo']/a/img")
	public WebElement logo;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement successful;

	@FindBy(xpath = "//a[@rel='nofollow']")
	public WebElement logOut;
	
	@FindBy(tagName="h2")
	public WebElement label_h2;
	
	@FindBy(linkText="LIST YOUR STAY")
	public WebElement listYourStay;
	
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
	                
	@FindBy(xpath="//input[@placeholder='Where are you going? (type your city, college, or metro)']")
	public WebElement searchBox;
	
	@FindBy(xpath = "//button[@class='btn search-btn']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@class='tooltip-inner']")
	public WebElement popUpPleaseEnter;
	

}
