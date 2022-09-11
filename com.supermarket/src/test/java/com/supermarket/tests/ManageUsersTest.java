package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {

	ManageUsersPage manageuserspage;
	LoginPage loginpage;

	@Test
	public void verifyAdminUserDeactivation() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.login();
		ManageUsersPage manageuserspage = new ManageUsersPage(driver);
		manageuserspage.clickOnManageUsers();
		manageuserspage.clickOnUsersDeactivateButton("Sree Parvathy");
		// driver.findElement(By.xpath("//tbody//tr[5]//td[5]//a")).click();
	}

	
	
	
	
}
