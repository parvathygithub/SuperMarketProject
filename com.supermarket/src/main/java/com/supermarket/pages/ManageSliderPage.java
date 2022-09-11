package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageSliderPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider'])[1]")
	private WebElement manageSlider;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement chooseFile;

	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement linkText;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;

	public ManageSliderPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageSlider() {

		manageSlider.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}

	public void enterLink() {

		linkText.sendKeys("https://www.pexels.com/search/flowers/");

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

	public void uploadImage() {

		clickOnManageSlider();
		clickOnNewButton();
		pageutility = new PageUtility(driver);
		pageutility.fileUpload(chooseFile,
				System.getProperty("user.dir") + "//UploadImage//" + "flower Image" + ".jpg");
		linkText.sendKeys("https://www.pexels.com/search/flowers/");
		saveButton.click();
	}

	public boolean uploadImageIsDisplayed() {
		generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(chooseFile);

	}
}
