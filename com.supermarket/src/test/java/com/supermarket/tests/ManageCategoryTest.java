package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCategoryPage;

public class ManageCategoryTest extends Base {

	ManageCategoryPage managecategorypage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifythatUploadImageIsDisplayedOrNot() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.enterCateogryInformations("House Hold Items");
		managecategorypage.uploadImage();
		boolean imageStatus = managecategorypage.uploadImageIsDisplayedOrNot();
		Assert.assertTrue(imageStatus);
	}

	@Test(priority = 2)
	public void verifyTheSearchButtonBackGroundColor() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickOnManageCategory();
		managecategorypage.clickOnCategory();
		String expectedColor = "rgba(0, 123, 255, 1)";
		String actualColor = managecategorypage.getSearchButtonBackgroundColor();
		Assert.assertEquals(expectedColor, actualColor);

	}

}
