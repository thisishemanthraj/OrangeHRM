package com.hrm.orange.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.orange.generic.WebActionUtil;

public class HomePage extends BasePage
{
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement adminMenu;
	
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pimMenu;
	
	@FindBy(id="menu_leave_viewLeaveModule")
	private WebElement leaveMenu;
	
	@FindBy(id="menu_time_viewTimeModule")
	private WebElement timeMenu;
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	private WebElement recruitmentMenu;	
	
	@FindBy(id="menu__Performance")
	private WebElement performanceMenu;
	
	@FindBy(id="menu_dashboard_index")
	private WebElement dashboardMenu;
	
	@FindBy(id="menu_directory_viewDirectory")
	private WebElement directoryMenu;
	
	@FindBy(linkText="Welcome Admin")
	private WebElement welcomeAdminLink;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	public HomePage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	public void clickOnMenu(String menuName)
	{
		menuName=menuName.toLowerCase();
		switch(menuName)
		{
			case "admin":webActionUtil.click(adminMenu);
						 break;
			case "pim":webActionUtil.click(pimMenu);
			 			 break;
			case "leave":webActionUtil.click(leaveMenu);
			 			 break;
			case "time":webActionUtil.click(timeMenu);
			 			 break;
			case "recruitment":webActionUtil.click(recruitmentMenu);
			 			 break;
			case "performance":webActionUtil.click(performanceMenu);
						 break;
			case "dashboard":webActionUtil.click(dashboardMenu);
			 			 break;
			case "directory":webActionUtil.click(directoryMenu);
			 			 break; 			 
		}
	}
	
	public void logout()
	{
		webActionUtil.click(welcomeAdminLink);
		webActionUtil.click(logoutLink);
	}
}
