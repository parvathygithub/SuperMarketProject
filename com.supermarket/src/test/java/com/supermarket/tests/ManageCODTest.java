package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCODPage;

public class ManageCODTest extends Base {

	ManageCODPage manageCODpage;
	LoginPage loginpage;

	@Test
	public void verifyThatCODAddedSuccessfully() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		manageCODpage = new ManageCODPage(driver);
		manageCODpage.addCODInformations();
		String expectedText = "×\n" + "Alert!\n" + "Cod Added Successfully";
		String actualText = manageCODpage.getTheTextOfAlertMessage();
		System.out.println(actualText);
		Assert.assertEquals(expectedText, actualText);

	}

}
