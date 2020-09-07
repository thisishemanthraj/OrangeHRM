package com.hrm.orange.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.orange.generic.Utilities;
import com.hrm.orange.generic.WebActionUtil;

public class PIMMenuPage extends BasePage
{
	@FindBy(id="menu_pim_viewEmployeeList")
	private WebElement employeeList;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmployee;
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="middleName")
	private WebElement middleName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="btnSave")
	private WebElement saveButton;
	
	@FindBy(id="resultTable")
	private WebElement resultTable;
		
	@FindBy(id="btnDelete")
	private WebElement deleteButton;
		
	@FindBy(id="dialogDeleteBtn")
	private WebElement okButton;
	
	@FindBy(xpath="//input[@class='btn cancel']")
	private WebElement cancelButton;
	
	private static String xpathForDeleteEmployee="//a[contains(text(),'name')]/../..//input[@type='checkbox']";
	
	
	public PIMMenuPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	public void addEmployee(String fn, String mn, String ln)
	{
		webActionUtil.click(addEmployee);
		webActionUtil.enter(firstName, fn);
		webActionUtil.enter(middleName, mn);
		webActionUtil.enter(lastName, ln);
		webActionUtil.click(saveButton);
	}
	
	public boolean verifyEmployeeInEmployeeList(String fn)
	{
		webActionUtil.click(employeeList);
		List<WebElement> names = resultTable.findElements(By.tagName("td"));
		for(WebElement name:names)
		{
			if(name.getText().contains(fn))
			{
				return true;
			}
		}
		return false;
	}

	public void deleteEmployeeFromEmployeeList(String fnAndMn) 
	{
		webActionUtil.click(employeeList);
		xpathForDeleteEmployee=xpathForDeleteEmployee.replace("name", fnAndMn);
		webActionUtil.click(driver.findElement(By.xpath(xpathForDeleteEmployee)));
		webActionUtil.click(deleteButton);
		clickOnOKOrCancelInDeletePopUp(true);
		Utilities.sleepInSeconds(15);
	}
	
	public void clickOnOKOrCancelInDeletePopUp(boolean okOrCancel)
	{
		if(okOrCancel)
		{
			webActionUtil.click(okButton);
		}
		else
		{
			webActionUtil.click(cancelButton);
		}
	}
	
}
