package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Private Room']")
	public WebElement privateRoom;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Private Room']")
	public WebElement sharedRoom;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Entire Place']")
	public WebElement entirePlace;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='House']")
	public WebElement house;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Apartment']")
	public WebElement apartment;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Townhouse']")
	public WebElement townhouse;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Dorm']")
	public WebElement dorm;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Hostel']")
	public WebElement hostel;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.property.number_of_bedrooms = vm.valueDown(vm.listing.property.number_of_bedrooms)']")
	public WebElement minesBedroomButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.property.number_of_bedrooms = vm.valueUp(vm.listing.property.number_of_bedrooms)']")
	public WebElement plusBedroomButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.property.number_of_beds = vm.valueDown(vm.listing.property.number_of_beds)']")
	public WebElement minesBedButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.property.number_of_beds = vm.valueUp(vm.listing.property.number_of_beds)']")
	public WebElement plusBedButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.property.number_of_bathrooms = vm.valueDown(vm.listing.property.number_of_bathrooms)']")
	public WebElement minesBathroomButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']//button[@ng-click='vm.listing.property.number_of_bathrooms = vm.valueUp(vm.listing.property.number_of_bathrooms)']")
	public WebElement plusBathroomButton;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Female']")
	public WebElement female;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='Male']")
	public WebElement male;
	
	@FindBy(xpath="//div[@class='col text-center']/div[.='No Preferrence']")
	public WebElement noReferenceGender;
	
	
	@FindBy(xpath="//input[@ng-model='vm.listing.property.amenities[amenity.key]']/../label")
	public List<WebElement> amentities;
	
	@FindBy(xpath="//label[.='Address Line 1']")
	public WebElement addresslabel;
	
	
	@FindBy(xpath="(//div[@class='col-12 form-group']/input)[1]")
	public WebElement address;
	
	@FindBy(xpath="(//div[@class='col-12 form-group']/input)[3]")
	public WebElement metro;
	
	@FindBy(xpath="//div[contains(@ng-class,'vm.listing.room.bath_type === ')]")
	public List<WebElement> bathroomType;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.room.number_of_beds = vm.valueDown(vm.listing.room.number_of_beds)']")
	public WebElement minesRoomBedButton;
	
	@FindBy(xpath="//div[@class='col-12 text-center']/button[@ng-click='vm.listing.room.number_of_beds = vm.valueUp(vm.listing.room.number_of_beds)']")
	public WebElement plusRoomBedButton;
	
	@FindBy(xpath="//div[@class='col-6']/div[@class='checkbox abc-checkbox abc-checkbox-primary']/label")
	public List<WebElement> foodDietery;
	
	@FindBy(xpath="//div[@class='col-6']//div[contains(@ng-repeat,'amenity in vm.room_amenities.slice')]/label")
	public List<WebElement> roomFeatures;
	
	@FindBy(xpath="//input[@ng-model='vm.listing.title']")
	public WebElement mainStayTitle;
	
	@FindBy(xpath="//textarea[@ng-model='vm.listing.description']")
	public WebElement mainStayDescription;
	
	@FindBy(xpath="//div[@ng-model='vm.listing.availability_details.dates.startDate']")
	public WebElement availableDateFrom;
	
	@FindBy(xpath="//div[@ng-model='vm.listing.availability_details.dates.endDate']")
	public WebElement availableDateTo;
	
	@FindBy(xpath="//input[@ng-model='vm.listing.availability_details.price_per_month']")
	public WebElement pricePerMonth;
	
	@FindBy(xpath="//input[@ng-model='vm.listing.availability_details.deposit']")
	public WebElement securityDeposit;

	@FindBy(xpath="//div[@class='col-12 form-group text-center']/button")
	public List<WebElement> minimumStay;
	
	@FindBy(xpath="//button[.='SEE WHAT YOU MISSED']")
	public WebElement seeWhatYouMissedButton;
	
	@FindBy(xpath="//button[.='NEXT']")
	public WebElement nextButton;
	
	@FindBy(xpath="(//th[@class='next available'])[3]")
	public WebElement calendarRightNextMonthArrow;
	
	@FindBy(xpath="//button[.='SAVE']")
	public WebElement saveButton;
	
	@FindBy(xpath="//input[@multiple='multiple']")
	public WebElement uploadPhotos;
	
	@FindBy(xpath="//button[.='REVIEW']")
	public WebElement reviewButton;
	
	@FindBy(xpath="//button[.='PUBLISH']")
	public WebElement publishButton;
	
	@FindBy(xpath="//span[.='Yes']")
	public WebElement acceptPublishingButton;
	
	@FindBy(xpath="//div[@class='owl-stage-outer']//a[not(contains(@ui-sref,'dashboard.admin'))]")
	public List<WebElement> topMenuElements;
	
	@FindBy(xpath="//a[.='ADD A STAY']")
	public WebElement addAStayButton;
	
	

	
	
	
}
