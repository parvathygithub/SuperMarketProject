package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;
import com.supermarket.utilities.ResponseCode;

public class LoginTest extends Base {

	LoginPage loginpage;

	@Test
	public void verifyLogin() {

		loginpage = new LoginPage(driver);
		loginpage.login();

	}

	@Test(groups = "smoke")
	public void verifyInvalidCredentialsErrorMessage() {

		loginpage = new LoginPage(driver);
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = loginpage.getInvalidLoginErrorMessage();
		System.out.println(actualAlertMessage);
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test(dataProvider = "adminUser", dataProviderClass = DataProviders.class)
	public void verifyCreatedAdminLogin(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login(userName, password);
		Assert.assertTrue(loginpage.getLoginStatus());

	}
	@Test
	public void verifyThatAdminLogout() {
		
		loginpage = new LoginPage(driver);
		loginpage.login();
		loginpage.clickOnAdmin();
		loginpage.clickOnLogout();
		Assert.assertTrue(loginpage.getLogoutStatus());
		
		
		
	}

}
