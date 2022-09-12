package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base {

	ManageOrdersPage manageorderspage;
	LoginPage loginpage;

	@Test(priority = 1)

	public void verifySearchButtonColor() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.login();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrders();
		String expectedColor = "rgba(0, 123, 255, 1)";
		String actualColor = manageorderspage.getSearchButtonBackgroundColor();
		Assert.assertEquals(expectedColor, actualColor);

	}

	@Test(priority = 2)
	public void verifyTheChangeStatusColor() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrders();
		String expectedColor = "rgba(40, 167, 69, 1)";
		String actualColor = manageorderspage.getChangeStatusBackgroundColor();
		Assert.assertEquals(expectedColor, actualColor);

	}

}
