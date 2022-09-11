package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	private WebElement manageLocation;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement countryDropDown;

	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	private WebElement enterState;

	@FindBy(xpath = "//input[@name='location']")
	private WebElement enterLocation;

	@FindBy(xpath = "//input[@name='delivery']")
	private WebElement enterDeliveryCharge;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	@FindBy(xpath = "//select[@id='country_id']/option[2]")
	private WebElement countryDropDownText;

	public ManageLocationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageLocation() {

		manageLocation.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}
	
	public void enterLocationField(String location) {

		enterLocation.sendKeys(location);

	}
	
	public void enterDeliverychargeField(String deliveryCharge) {

		enterDeliveryCharge.sendKeys(deliveryCharge);

	}
	
	public void clickOnSaveButton() {
		
		saveButton.click();
		
	}

	public void enterLocalInformations(String country, String state, String location,String deliveryCharge) {

		clickOnManageLocation();
		clickOnNewButton();
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(countryDropDown, country);
		pageutility.select_ByVisibleText(enterState, state);
		enterLocationField(location);
		enterDeliverychargeField(deliveryCharge);
		clickOnSaveButton();

	}

	public String getTextOfselectCountry(String country) {

		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtility(driver);
		pageutility.select_ByVisibleText(countryDropDown, country);
		return generalutility.getTextOfElement(countryDropDownText);

	}

}
