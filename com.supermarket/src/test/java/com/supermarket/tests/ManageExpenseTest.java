package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;

public class ManageExpenseTest extends Base {

	ManageExpensePage manageexpensepage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyThatExpenseCategoryCreatedSuccessfullyOrNot() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageexpensepage = new ManageExpensePage(driver);
		manageexpensepage.enterProduct("CashewNut");
		String expectedAlertText = "Alert!";
		String actualAlertText = manageexpensepage.getTheTextOfAlertMessage();
		Assert.assertEquals(expectedAlertText, actualAlertText);

	}

}