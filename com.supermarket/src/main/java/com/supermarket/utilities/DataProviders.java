package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ExcelUtility excelutility = new ExcelUtility();

	@DataProvider(name = "adminUse")
	public Object[][] adminUse() {
		return new Object[][] { { "deliveryboy1", "deliveryboy1" }, { "admin123", "admin" }, { "Parvathy", "paru" },
				{ "qwerty", "qwerty" } };
	}

	@DataProvider(name = "adminUser")
	public Object[][] adminUser() {

		excelutility.setExcelFile("loginData", "AdminUserCredentials");
		Object data[][] = excelutility.getMultidimentionalData(4, 2);
		return data;
	}
}
