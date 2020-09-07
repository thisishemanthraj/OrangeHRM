package com.hrm.orange;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hrm.orange.generic.AutoConstants;
import com.hrm.orange.generic.TakeErrorScreenShot;
import com.hrm.orange.generic.WebActionUtil;
import com.hrm.orange.pages.HomePage;
import com.hrm.orange.pages.LoginPage;

public class BaseTest implements AutoConstants
{
	WebDriver driver;
	WebActionUtil webActionUtil;
	
	@Parameters({"browserName", "appURL", "ito", "eto"})
	@BeforeClass
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(DEFAULT_APP_URL)String appURL,
						@Optional(ITO)String ito,
						@Optional(ETO)String eto)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else
		{
			throw new IllegalArgumentException("This Browser is Not Supported for Our Application");
		}
		
		
		long implicitTO = Long.parseLong(ito);
		long explicitTO = Long.parseLong(eto);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitTO, TimeUnit.SECONDS);
		driver.get(appURL);
		webActionUtil = new WebActionUtil(driver, explicitTO);
	}
	
	@Parameters({"un","pwd"})
	@BeforeMethod
	public void loginToApp(@Optional(DEFAULT_USERNAME)String un, @Optional(DEFAULT_PASSWORD)String pwd)
	{
		LoginPage lp = new LoginPage(driver, webActionUtil);
		lp.login(un, pwd);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult result)
	{
		String testCaseName=result.getMethod().getMethodName();
		int status=result.getStatus();
		System.out.println(status);
		if(status==ITestResult.FAILURE)
		{
			TakeErrorScreenShot.getPageScreenshot(driver, IMG_PATH, testCaseName);
		}
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.logout();
	}
	
	@AfterClass
	public void closeApp()
	{
		driver.quit();
	}
}






