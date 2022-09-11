package com.supermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	Select select;
	Actions action;

	public PageUtility(WebDriver driver) {

		this.driver = driver;

	}

	public void ClearTextField(WebElement element) {
		element.clear();
	}

	public void select_ByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void select_ByVisibleText(WebElement element, String text) {
			select = new Select(element);
			select.selectByVisibleText(text);	
	}

	public void moveTo_Element(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick().build().perform();
	}

	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();
	}

	public void switch_To_Frame_by_Name(String name) {

		driver.switchTo().frame(name);

	}

	public void fileUpload(WebElement element, String path) {

		element.sendKeys(path);

	}

	public void scroll_By(int x, int y) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scroll_into_View(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public boolean checkClickstatus(WebElement element) {
		try {
			element.click();
			return false;

		} catch (Exception e) {

			return true;
		}

	}

	public void scrollAndclick(WebElement element) {
		int x = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (checkClickstatus(element)) {
			js.executeScript("window.scrollBy(0," + x + ")");
			x = x + 50;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
