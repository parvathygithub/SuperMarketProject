package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base {

	ManageOrdersPage manageorderspage;
	LoginPage loginpage;

	@Test

	public void verifySearchButtonColor() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.login();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnManageOrders();
		String expectedColor = "rgba(0, 123, 255, 1)";
		String actualColor = manageorderspage.getSearchButtonBackgroundColor();
		Assert.assertEquals(expectedColor, actualColor);

	}

}
