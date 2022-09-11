package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageProductPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[1]")
	private WebElement manageProduct;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement enterTitle;

	@FindBy(xpath = "//input[@value='Nonveg']")
	private WebElement nonveg_RadioButton;

	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryDropDown;
	
	@FindBy(xpath = "//select[@id='cat_id']/option[2]")
	private WebElement categoryDropDownText;

	public ManageProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageProduct() {

		manageProduct.click();

	}

	public void clickOnNewButton() {

		newButton.click();

	}
	
	public void enterTitle(String product) {
		
		enterTitle.sendKeys(product);
		
	}
	
	public void clickOnRadioButton() {
		
		nonveg_RadioButton.click();
		
	}

	public void enterProductInformations(String product) {

		clickOnManageProduct();
		clickOnNewButton();
		enterTitle(product);
		clickOnRadioButton();

	}

	public String getTextOfCategoryDropDown() {

		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtility(driver);
		pageutility.select_ByVisibleText(categoryDropDown, "Fruits & Vegetables");
		return generalutility.getTextOfElement(categoryDropDownText);
	}

}
