package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {

	WebDriver driver;
	ExcelUtility excel = new ExcelUtility();
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	private WebElement manageDeliveryBoy;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement nameField;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressField;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	@FindBy(xpath = "//tr//td[6]")
	private WebElement clickStatus;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertStatus;

	public ManageDeliveryBoyPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliveryBoy() {

		manageDeliveryBoy.click();

	}

	public void clickOnNewButton() {

		newButton.click();
	}

	public void enterName(String name) {

		nameField.sendKeys(name);

	}

	public void enterEmail(String email) {

		emailField.sendKeys(email);
	}

	public void enterPhoneNumber(String phoneNumber) {

		phoneNumberField.sendKeys(phoneNumber);

	}

	public void enterAddress(String address) {

		addressField.sendKeys(address);
	}

	public void enterUserName(String userName) {

		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);

	}

	public void clickOnSaveButton() {

		saveButton.click();
	}

	public void addDeliveryBoyInformations() {

		clickOnManageDeliveryBoy();
		clickOnNewButton();
		pageutility = new PageUtility(driver);
		excel.setExcelFile("DeliveryBoyData", "DeliveryBoyInformations");
		String name = excel.getCellData(1, 0);
		String email = excel.getCellData(1, 1);
		String address = excel.getCellData(1, 2);
		String userName = excel.getCellData(1, 3);
		String password = excel.getCellData(1, 4);
		String phoneNumber = excel.getCellData(1, 5);
		enterName(name);
		enterEmail(email);
		enterPhoneNumber(phoneNumber);
		enterAddress(address);
		enterUserName(userName);
		enterPassword(password);
		pageutility.scrollAndclick(saveButton);
	}

	public void clickOnStatus() {

		clickStatus.click();
	}

	public String getTheTextOfAlertStatus() {
		clickOnStatus();
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(alertStatus);

	}

}
