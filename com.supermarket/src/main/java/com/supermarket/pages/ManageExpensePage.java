package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageExpensePage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//li[@class='nav-item has-treeview'])[1]")
	private WebElement manageExpense;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']")
	private WebElement expenseCategory;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement sendTitle;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchBar;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement enterTitle;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement alertText;

	public ManageExpensePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageExpense() {

		manageExpense.click();

	}

	public void clickOnExpenseCategory() {

		expenseCategory.click();
	}

	public void clickOnNewButton() {

		newButton.click();

	}

	public void enterTitle(String product) {

		sendTitle.sendKeys(product);

	}

	public void clickOnSaveButton() {

		saveButton.click();

	}

	public void enterProduct(String product) {

		clickOnManageExpense();
		clickOnExpenseCategory();
		clickOnNewButton();
		enterTitle(product);
		clickOnSaveButton();

	}
	public String getTheTextOfAlertMessage() {
		
		generalutility=new GeneralUtility(driver);
		return generalutility.getTextOfElement(alertText);
		
	}

	
	}

