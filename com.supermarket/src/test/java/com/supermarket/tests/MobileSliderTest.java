package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.MobileSliderPage;

public class MobileSliderTest extends Base {

	MobileSliderPage mobilesliderpage;
	LoginPage loginpage;
	
	
	@Test
	public void verifyTheTextOfSelectedCategory() {
		
		loginpage = new LoginPage(driver);
		loginpage.login();
		mobilesliderpage=new MobileSliderPage(driver);
		mobilesliderpage.SelectCategoryDropDown("Snacks & Branded Foods");
		String expectedText="Snacks & Branded Foods";
		String actualText= mobilesliderpage.getTextOfSelectedCategoryDropDown();
		Assert.assertEquals(expectedText, actualText);
		
	}
	
	@Test
	public void verifyTheUploadImageIsDisplayed() {
		
		loginpage = new LoginPage(driver);
		loginpage.login();
		mobilesliderpage=new MobileSliderPage(driver);
		mobilesliderpage.uploadImage();
		boolean imageStatus=mobilesliderpage.uploadImageIsDisplayed();
		Assert.assertTrue(imageStatus);
		
		
	}
	
	
	
	
	
	

}
