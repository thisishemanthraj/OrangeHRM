package com.hrm.orange.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TakeErrorScreenShot
{
	public static String getPageScreenshot(WebDriver driver, String imagePath, String testCaseName)
	{
		LocalDateTime ldt = LocalDateTime.now();
		String timeStamp = ldt.toString().replace(':', '-');
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String imageFilePath = imagePath+testCaseName+timeStamp+".png";
		File destFile = new File(imageFilePath);
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return imageFilePath;
	}
	
	public static String getWebElementScreenshot(WebElement target, String imagePath, String testCaseName)
	{
		LocalDateTime ldt = LocalDateTime.now();
		String timeStamp = ldt.toString().replace(':', '-');
		
		
		File srcFile = target.getScreenshotAs(OutputType.FILE);
		String imageFilePath = imagePath+testCaseName+timeStamp+".png";
		File destFile = new File(imageFilePath);
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return imageFilePath;
	}
}
