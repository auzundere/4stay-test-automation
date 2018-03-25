package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HostPage {
	private WebDriver driver;
//s1
	public HostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='icon private-room']")
	public WebElement privateRoom;
	
	@FindBy(xpath="//div[@class='icon shared-room']")
	public WebElement sharedRoom;
	
	@FindBy(xpath="//div[@class='icon entire-place']")
	public WebElement entirePlace;
	
	@FindBy(xpath="//a[.='Stay Type']/../i")
	public WebElement stayTypeMarker;
	
	@FindBy(xpath="//a[.='Stay Type']")
	public WebElement stayTypeLabel;
	
	@FindBy(xpath="//a[.='Property details']/../i")
	public WebElement propertyDetailsMarker;
	
	@FindBy(xpath="//a[.='Property details']")
	public WebElement propertyDetailsLabel;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement buttonNext;
	
	@FindBy(xpath="//div[@class='icon house']")
	public WebElement house;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary btn-circle'])[2]")
	public WebElement plusBadroom;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary btn-circle'])[6]")
	public WebElement plusBathroom;
	
	@FindBy(xpath ="//div[@class='icon female']")
	public WebElement femaleIcon;
	
	@FindBy(id="wifi")
	public WebElement wifi;
	
	@FindBy(id="cats_okay")
	public WebElement catsOkay;
	

	
	//--------------------------
	
	// List of elements (icons on Host Page)
		@FindBy(xpath = "//div[@class='col text-center']")
		public List<WebElement> hostIcons;
}
