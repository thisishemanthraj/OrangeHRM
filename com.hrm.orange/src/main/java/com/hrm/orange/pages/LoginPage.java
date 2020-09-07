package com.hrm.orange.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.orange.generic.Utilities;
import com.hrm.orange.generic.WebActionUtil;

public class LoginPage extends BasePage
{
	//Login Page Strings
	final static String LOGIN_PAGE_TITLE = "OrangeHRM";
	
	//Creating WebElements of Login Page
	@FindBy(id="txtUsername")
	private WebElement usernameTextbox;
	
	@FindBy(id="txtPassword")
	private WebElement passwordTextbox;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	@FindBy(id="spanMessage")
	private WebElement errorMsg;
	
	
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	//Action Methods
	public void login(String un, String pwd)
	{
		webActionUtil.enter(usernameTextbox,un);
		webActionUtil.enter(passwordTextbox,pwd);
		webActionUtil.click(loginButton);
	}
	
	public boolean verifyLoginErrorMsg()
	{
		Utilities.sleepInSeconds(3);
		return errorMsg.isDisplayed();
	}
	
	public boolean verifyLoginPageTitle()
	{
		return webActionUtil.verifyTitle(LOGIN_PAGE_TITLE);
	}
}
