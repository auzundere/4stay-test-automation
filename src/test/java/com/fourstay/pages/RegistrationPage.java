package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="h5")
	public WebElement iWantToBe;
	
	@FindBy(xpath ="//div[@class='role-icon host-icon']")
	public WebElement hostButton; 
	
	@FindBy(xpath ="//div[@class='role-icon guest-icon selected']")
	public WebElement guestButton; 
	
	@FindBy(xpath= "//a[@class='btn btn-primary w-100 m-0 mb-3']")
	public WebElement nextButton;	
	
	@FindBy(xpath="(//*[@id=\"occupation\"])[1]")
	public WebElement emailAddress;
	
	@FindBy(xpath="(//*[@id=\"occupation\"])[2]")
	public WebElement occupation;
	
	@FindBy(xpath="form-control ng-pristine ng-untouched ng-empty ng-valid-maxlength ng-valid ng-valid-required")
	public WebElement phoneNumber;
	
	@FindBy(xpath="//textarea[@class='md-textarea form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']")
	public WebElement tellUsAbout;
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-empty ng-invalid ng-invalid-required ng-valid-maxlength ng-touched']")
	public WebElement yearOfBirth;
	
	@FindBy(xpath="//label[contains(text(),'Email address *')]")
	public WebElement labelEmailAddress;
	
	@FindBy(xpath="//label[contains(text(),'Occupation/School')]")
	public WebElement labelOccupation;
	
	@FindBy(xpath="//button[@class='btn btn-primary w-100 m-0 ng-binding']")
	public WebElement saveButton;
}
