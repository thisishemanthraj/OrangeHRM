package com.hrm.orange.generic;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebActionUtil
{
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	WebDriverWait wait;
	public WebActionUtil(WebDriver driver, long eto) 
	{
		this.driver=driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, eto);
	}
	
	public void click(WebElement target)
	{
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void enter(WebElement target, String keysToEnter)
	{
		target.clear();
		target.sendKeys(keysToEnter);
	}
	
	public void moveToElement(WebElement target)
	{		
		actions.moveToElement(target).perform();
	}
	
	public void dragAndDrop(WebElement source, WebElement target)
	{
		actions.dragAndDrop(source, target).perform();;
	}
	
	public void javascriptClick(WebElement target)
	{
		js.executeScript("arguments[0].click();", target);
	}
	
	public void scrollDown(int pixels)
	{
		js.executeScript("window.scrollBy(0,"+pixels+");");
	}
	
	public void scrollUp(int pixels)
	{
		js.executeScript("window.scrollBy(0,-"+pixels+");");
	}
	
	public void selectByVisibleText(WebElement target, String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);
	}
	
	public void multiSelectByVisibleText(WebElement target, String... text)
	{
		Select select = new Select(target);
		if(select.isMultiple())
		{
			for(String s:text)
			{
				select.selectByVisibleText(s);
			}
		}
		else
		{
			throw new IllegalArgumentException("Its not MultiSelect DropDown");
		}
	}
	
	public void switchToFrame(String indexIdOrName)
	{
		Utilities.sleepInSeconds(5);
		try
		{
			int index = Integer.parseInt(indexIdOrName);
			driver.switchTo().frame(index);
		}
		catch(NumberFormatException e)
		{
			driver.switchTo().frame(indexIdOrName);
		}
	}
	
	public boolean verifyTitle(String expectedTitle)
	{
		return wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
}
