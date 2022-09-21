package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	AdminUsersPage adminuserspage;
	LoginPage loginpage;
	ExcelUtility excel = new ExcelUtility();

	@Test(priority = 1,groups = "smoke")
	public void verifyNewAdminUserCanBeCreated() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserspage = new AdminUsersPage(driver);
		excel.setExcelFile("NewAdminUsers", "AdminUsers");
		String userName = excel.getCellData(1, 0);
		String password = excel.getCellData(1, 1);
		adminuserspage.addAdminUsersInformations(userName, password, "Staff");
		String expectedAlertText = "×\n" + "Alert!\n" + "User Created Successfully";
		String actualAlertText = adminuserspage.getTheTextOfAlertText();
		Assert.assertEquals(expectedAlertText, actualAlertText);

	}

}
