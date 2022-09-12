package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyThatDeliveryBoyStatusChangedSuccessfullyOrNot() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.addDeliveryBoyInformations();
		String expectedStatus = "×\n" + "Alert!\n" + "Delivery Boy Status Changed Successfully";
		String actualStatus = managedeliveryboypage.getTheTextOfAlertStatus();
		Assert.assertEquals(expectedStatus, actualStatus);

	}

}
