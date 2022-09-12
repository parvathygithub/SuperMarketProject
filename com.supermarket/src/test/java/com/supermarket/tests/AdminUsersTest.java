package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;

public class AdminUsersTest extends Base {

	AdminUsersPage adminuserspage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verifyifNewAdminUserCanBeCreated() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.addAdminUsersInformations("Staff");
		String expectedAlertText = "×\n" + "Alert!\n" + "User Created Successfully";
		String actualAlertText = adminuserspage.getTheTextOfAlertText();
		Assert.assertEquals(expectedAlertText, actualAlertText);

	}

}
