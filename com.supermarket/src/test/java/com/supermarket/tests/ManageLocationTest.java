package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {

	ManageLocationPage managelocationpage;
	LoginPage loginpage;
	
	
	
	@Test
	public void verifyEnterLocalInformation() {
			
			loginpage = new LoginPage(driver);
			loginpage.login();
			managelocationpage=new ManageLocationPage(driver);
			managelocationpage.enterLocalInformations("United Kingdom", "England", "NorthWest","300" );
			String expectedAlertText="United Kingdom";
			String actualAlertText= managelocationpage.getTextOfselectCountry("United Kingdom");
			System.out.println(actualAlertText);
		    Assert.assertEquals(expectedAlertText, actualAlertText);
	
	
	
	}
	

	

}
