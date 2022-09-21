package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;
import com.supermarket.utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	ExcelUtility excel = new ExcelUtility();

	@Test(priority = 1)
	public void verifyDeliveryBoyStatus() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		excel.setExcelFile("DeliveryBoyData", "DeliveryBoyInformations");
		String name = excel.getCellData(1, 0);
		String email = excel.getCellData(1, 1);
		String address = excel.getCellData(1, 2);
		String userName = excel.getCellData(1, 3);
		String password = excel.getCellData(1, 4);
		String phoneNumber = excel.getCellData(1, 5);
		managedeliveryboypage.addDeliveryBoyInformations(name, email, address, userName, password, phoneNumber);
		String expectedStatus = "×\n" + "Alert!\n" + "Delivery Boy Status Changed Successfully";
		String actualStatus = managedeliveryboypage.getTheTextOfAlertStatus();
		Assert.assertEquals(expectedStatus, actualStatus);

	}

}
