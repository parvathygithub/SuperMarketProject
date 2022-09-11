package com.supermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	TakesScreenshot scrShot;

	public void takeScreenShot(WebDriver driver, String imageName) {

		try {
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			scrShot = (TakesScreenshot) driver;
			File screenshot = scrShot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "//ScreenShots//" + imageName + timeStamp + ".png";
			File finalDestination = new File(destination);
			FileHandler.copy(screenshot, finalDestination);

		} catch (Exception e) {
			
			e.printStackTrace();

		}

	}

}
