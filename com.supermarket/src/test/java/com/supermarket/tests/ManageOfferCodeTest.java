package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOfferCodePage;

public class ManageOfferCodeTest extends Base {

	ManageOfferCodePage manageoffercodepage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyThatOfferCreatedSuccessfullyOrNot() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.enterOfferCodeInformations("F101", "6%", "300");
		String expectedAlertText = "×\n" + "Alert!\n" + "Offer Created Successfully";
		String actualAlertText = manageoffercodepage.getTheTextOfAlertMessage();
		Assert.assertEquals(expectedAlertText, actualAlertText);

	}

	@Test(priority = 2)
	public void verifyThatOfferCodeAlreadyExists() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageoffercodepage = new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnManageOfferCode();
		String expectedAlertText = "16px";
		String actualAlertText = manageoffercodepage.getResetButtonFontSize();
		Assert.assertEquals(expectedAlertText, actualAlertText);

	}

}
