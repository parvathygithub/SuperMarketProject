package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageOfferCodePage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode'])[1]")
	private WebElement manageOfferCode;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='offer_code']")
	private WebElement offerCodeField;

	@FindBy(xpath = "//input[@value='yes']")
	private WebElement firstOrderUser;

	@FindBy(xpath = "//input[@id='offer_per']")
	private WebElement percentageField;

	@FindBy(xpath = "//input[@id='offer_price']")
	private WebElement amountField;

	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessage;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	
	@FindBy(xpath = "//tbody//tr[1]//td[3]")
	private WebElement amount;
	
	

	public ManageOfferCodePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOfferCode() {

		manageOfferCode.click();
	}

	public void clickOnNewButton() {

		newButton.click();
	}

	public void enterOfferCode(String offerCode) {

		offerCodeField.sendKeys(offerCode);
	}

	public void clickRadioButton() {

		firstOrderUser.click();

	}

	public void enterPercentage(String percentage) {

		percentageField.sendKeys(percentage);
	}

	public void enterAmount(String amount) {

		amountField.sendKeys(amount);

	}

	public void uploadImage() {

		pageutility = new PageUtility(driver);
		pageutility.fileUpload(chooseFile, System.getProperty("user.dir") + "//UploadImage//" + "OfferFood" + ".jpg");
		pageutility.scrollAndclick(saveButton);
	}

	public void enterOfferCodeInformations(String offerCode, String percentage, String amount) {

		clickOnManageOfferCode();
		clickOnNewButton();
		enterOfferCode(offerCode);
		clickRadioButton();
		enterPercentage(percentage);
		enterAmount(amount);
		uploadImage();

	}

	public String getTheTextOfAlertMessage() {

		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(alertMessage);

	}

	public String getResetButtonFontSize() {

		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.getCssSelectorValue(resetButton, "font-size");

	}
	
	public String getEnteredAmount() {
		
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(amount);
		
		
		
	}

}
