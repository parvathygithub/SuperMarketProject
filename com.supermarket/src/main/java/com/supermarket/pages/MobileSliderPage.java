package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class MobileSliderPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider'])[1]")
	private WebElement mobileSlider;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement categoryDropDown;

	@FindBy(xpath = "//select[@id='cat_id']/option[4]")
	private WebElement categoryDropDownText;

	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement chooseFile;

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/uploads/small/1662356316_0e70acedc096a0e732a2.jpg']")
	private WebElement uploadImage;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	public MobileSliderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMobileSlider() {

		mobileSlider.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}

	public void clickOnChooseFile() {

		chooseFile.click();

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

	public void SelectCategoryDropDown(String category) {

		clickOnMobileSlider();
		clickOnNewButton();
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(categoryDropDown, category);
		saveButton.click();
		

	}
	
	public String getTextOfSelectedCategoryDropDown() {
		
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(categoryDropDownText);
		
	}
	
	public void  uploadImage() {
		
		clickOnMobileSlider();
		clickOnNewButton();
		pageutility = new PageUtility(driver);
		pageutility.fileUpload(chooseFile,System.getProperty("user.dir") + "//UploadImage//" + "Snacks & Branded  Foods" + ".jpg");
		saveButton.click();
		
		
	}
	
	public boolean uploadImageIsDisplayed() {
		generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(chooseFile);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}