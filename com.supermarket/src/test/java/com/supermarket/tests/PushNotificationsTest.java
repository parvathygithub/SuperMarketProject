package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;

public class PushNotificationsTest extends Base {

	PushNotificationsPage pushnotificationspage;
	LoginPage loginpage;

	@Test(priority = 1)
	public void  verifyThatTheNotificationMessageSendSuccessfullyOrNot () {

		loginpage = new LoginPage(driver);
		loginpage.login();
		pushnotificationspage = new PushNotificationsPage(driver);
		pushnotificationspage.addPushNotificationsInformations("Delivering Promotions ",
				"mobile orders and payments at no additional cost till Sept 2022");
		String expectedAlertMessage = "×\n" + "Alert!\n" + "Message send successfully";
		String actualAlertMessage = pushnotificationspage.getTheTextOfAlertMessage();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}

}
