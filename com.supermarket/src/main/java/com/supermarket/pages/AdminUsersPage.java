package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	private WebElement adminUsers;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement user_TypeField;

	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertText;

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsers() {

		adminUsers.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}

	public void enterUserName(String userName) {

		userNameField.sendKeys(userName);

	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void enterUserType(String userType) {

		user_TypeField.sendKeys(userType);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void selectUserType(String userType) {

		pageutility = new PageUtility(driver);

		if (userType.equals("Staff")) {
			pageutility.select_ByVisibleText(user_TypeField, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.select_ByVisibleText(user_TypeField, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.select_ByVisibleText(user_TypeField, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.select_ByVisibleText(user_TypeField, "Delivery Boy");
		}

	}

	public void addAdminUsersInformations(String userName, String password, String userType) {

		clickOnAdminUsers();
		clickOnNewButton();
		enterUserName(userName);
		enterPassword(password);
		selectUserType(userType);
		clickOnSaveButton();

	}

	public String getTheTextOfAlertText() {

		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(alertText);
	}

}