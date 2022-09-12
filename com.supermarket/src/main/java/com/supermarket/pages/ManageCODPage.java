package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageCODPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/add-cod']")
	private WebElement manageCOD;

	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement radioButton;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	public ManageCODPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageCoD() {

		manageCOD.click();

	}

	public void clickOnRadioButton() {

		radioButton.click();

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

	public void addCODInformations() {

		clickOnManageCoD();
		clickOnRadioButton();

	}

	public String getTheTextOfAlertMessage() {

		generalutility = new GeneralUtility(driver);
		clickOnSaveButton();
		return generalutility.getTextOfElement(alertMessage);

	}

}
