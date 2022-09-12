package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageCategoryPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//li[@class='nav-item has-treeview'])[3]")
	private WebElement manageCategory;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[1]")
	private WebElement category;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterCategory;

	@FindBy(xpath = "//li[@id='1-selectable']")
	private WebElement selectGroups1;

	@FindBy(xpath = "//li[@id='2-selectable']")
	private WebElement selectGroups2;

	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement clickSaveButton;

	public ManageCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageCategory() {

		manageCategory.click();

	}

	public void clickOnCategory() {

		category.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}

	public void enterCategory(String cateogryProduct) {

		enterCategory.sendKeys(cateogryProduct);

	}

	public void selectGroups() {

		selectGroups1.click();
		selectGroups2.click();

	}

	public void enterCateogryInformations(String cateogryProduct) {

		clickOnManageCategory();
		clickOnCategory();
		clickOnNewButton();
		enterCategory(cateogryProduct);
		selectGroups();

	}

	public void uploadImage() {

		pageutility = new PageUtility(driver);
		pageutility.fileUpload(chooseFile,
				System.getProperty("user.dir") + "//UploadImage//" + "House Hold Items" + ".jpg");
		pageutility.scrollAndclick(clickSaveButton);
	}

	public boolean uploadImageIsDisplayedOrNot() {

		generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(chooseFile);

	}

}
