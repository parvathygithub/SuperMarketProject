package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageSliderPage;

public class ManageSliderTest extends Base {

	ManageSliderPage managesliderpage;
	LoginPage loginpage;

	@Test
	public void verifyUploadImageIsDisplayed() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		managesliderpage = new ManageSliderPage(driver);
		managesliderpage.uploadImage();
		boolean uploadImageStatus = managesliderpage.uploadImageIsDisplayed();
		Assert.assertTrue(uploadImageStatus);

	}
	 
	 
	 
	 
	 
	 
	 
	 

}
