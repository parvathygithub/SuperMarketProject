package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageUsersPage {

	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user']")
	private WebElement manageUsers;

	public ManageUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageUsers() {
		manageUsers.click();
	}

	public void clickOnUsersDeactivateButton(String userName) {

		int j = 0;

		List<String> UsersName = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		UsersName = generalutility.getTextOfElements("//tr//td[1]");

		for (j = 0; j < UsersName.size(); j++) {
			if (UsersName.get(j).equals(userName)) {
				j++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[5]//a"));

		pageutility.scrollAndclick(deactivateButton);

	}

	{

	}

}
