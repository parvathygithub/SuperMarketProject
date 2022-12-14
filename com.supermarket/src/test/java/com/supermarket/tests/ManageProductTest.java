package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;

public class ManageProductTest extends Base {

	ManageProductPage manageproductpage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyLoginManageProduct() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageproductpage = new ManageProductPage(driver);
		manageproductpage.enterProductInformations("Mutton");
		String expectedText = "Fruits & Vegetables";
		String actualText = manageproductpage.getTextOfCategoryDropDown("Fruits & Vegetables");
		System.out.println(actualText);
		Assert.assertEquals(expectedText, actualText);

	}

}
