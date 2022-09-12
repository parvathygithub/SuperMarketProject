package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class PushNotificationsPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications'])[1]")
	private WebElement pushNotifications;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleField;

	@FindBy(xpath = "//input[@id='description']")
	private WebElement descriptionField;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertmessage;

	public PushNotificationsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPushNotifications() {

		pushNotifications.click();
	}

	public void enterTitle(String title) {

		titleField.sendKeys(title);
	}

	public void enterDescription(String description) {

		descriptionField.sendKeys(description);

	}

	public void clickOnSendButton() {

		sendButton.click();
	}

	public void addPushNotificationsInformations(String title, String description) {

		clickOnPushNotifications();
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();

	}

	public String getTheTextOfAlertMessage() {

		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(alertmessage);

	}

}
