package com.hrm.orange;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.orange.pages.HomePage;
import com.hrm.orange.pages.PIMMenuPage;

public class TC001 extends BaseTest
{
	@Test(description="Verify whether added Employee is Displayed In Employee List")
	public void testEmployeeIsDisplayed()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.clickOnMenu("pim");
		PIMMenuPage pim = new PIMMenuPage(driver, webActionUtil);
		pim.addEmployee("Shah", "Rukh", "Khan");
		Assert.assertEquals(pim.verifyEmployeeInEmployeeList("Shah"), false);
	}
}
