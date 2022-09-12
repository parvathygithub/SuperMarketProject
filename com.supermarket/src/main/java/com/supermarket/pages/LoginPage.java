package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;

public class LoginPage {

	WebDriver driver;
	ExcelUtility excel = new ExcelUtility();
	GeneralUtility generalutility;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']/h5")
	private WebElement invalidLoginalertMessage;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	private WebElement profileImage;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement admin;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logout;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement logoutStatus;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void enterUserName(String userName) {

		userNameField.sendKeys(userName);

	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {

		signInButton.click();
	}

	public void clickOnAdmin() {

		admin.click();
	}

	public void clickOnLogout() {

		logout.click();
	}

	public void login(String userName, String password) {

		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void login() {

		excel.setExcelFile("LoginData", "ValidLoginCredentials");
		String userName = excel.getCellData(1, 0);
		String password = excel.getCellData(1, 1);
		enterUserName(userName);
		enterPassword(password);
		clickOnLoginButton();
	}

	public String getInvalidLoginErrorMessage() {

		generalutility = new GeneralUtility(driver);
		excel.setExcelFile("LoginData", "InValidLoginCredentials");
		String userName = excel.getCellData(1, 0);
		String password = excel.getCellData(1, 1);
		login(userName, password);
		return generalutility.getTextOfElement(invalidLoginalertMessage);

	}

	public boolean getLoginStatus() {
		generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(profileImage);

	}

	public boolean getLogoutStatus() {

		generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(logoutStatus);

	}

}