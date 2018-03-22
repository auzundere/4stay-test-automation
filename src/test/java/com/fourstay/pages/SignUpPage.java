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
	
	public boolean isAt() {
		return driver.getTitle().equals("Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay");
	}
	
	@FindBy(xpath="//a[@class='btn facebook-btn w-100 m-0 mb-3']")
	public WebElement facebookButton;
	
	@FindBy(xpath="//a[@class='btn google-btn w-100 m-0 mb-3']")
	public WebElement googleButton;
	
	@FindBy(xpath="//div[@class='btn email-btn w-100 m-0 mb-3']")
	public WebElement emailButton;
	
	@FindBy(xpath="//div[@class='logo animated fadeInDown ml-auto mr-auto']")
	public WebElement loginText;
	
	@FindBy(xpath="//a[@ui-sref='sign-up.more-options']")
	public WebElement moreOptions;
	
	/**
	 * Basic Information for registration STARTS HERE
	*/
	
	@FindBy(xpath="//input[@id='first-name']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailAddess;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[.='Sign up']")
	public WebElement signUpButton;
	
	@FindBy(xpath="//li[@ng-repeat='error in vm.errors']")
	public WebElement errorMsg;
	
	/**
	 * Basic Information for registration ENDS HERE
	*/
	
	
	@FindBy(tagName="h5")
	public WebElement h5IwantToBe;
	
	@FindBy(xpath="//*[@id='sign-up-wrapper-first-screen']//h5/..//div[@class='d-flex flex-row justify-content-around w-75']/div[contains(@class,'host')]")
	public WebElement hostButton;
	
	@FindBy(xpath="//*[@id='sign-up-wrapper-first-screen']//h5/..//div[@class='d-flex flex-row justify-content-around w-75']/div[contains(@class,'guest')]")
	public WebElement guestButton;
	
	@FindBy(xpath="//a[@class='btn btn-primary w-100 m-0 mb-3']")
	public WebElement nextButton;
	
	@FindBy(xpath="//div[@class='md-form d-flex flex-row justify-content-center file-field']//span")
	public WebElement changeProfileImageButton;
	
	@FindBy(xpath="//input[@ng-model='vm.user.occupation_or_school']")
	public WebElement occupationOrSchool;
	
	public WebElement phone;
	
	public WebElement about_me;
	
	public WebElement dob;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100 m-0 ng-binding']")
	public WebElement saveButton;
	
	//add by Evgeniya
	@FindBy(xpath="//label[contains(text(),'Email address *')]")
	public WebElement labelEmailAddress;
	
	//add by Evgeniya
	@FindBy(xpath="//label[contains(text(),'Occupation/School')]")
	public WebElement labelOccupation;
}
