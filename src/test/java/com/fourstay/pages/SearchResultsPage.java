package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	private WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='map']")
	public WebElement maps;
	
	@FindBy(xpath="//div[@class='col-xl-6 col-lg-6 col-md-5 col-sm-12 col-6 pr-0']/input")
	public WebElement searckBoxOnResultsPage;
	
	
	
	
}
