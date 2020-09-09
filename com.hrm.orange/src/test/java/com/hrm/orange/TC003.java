package com.hrm.orange;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrm.orange.pages.HomePage;
import com.hrm.orange.pages.PIMMenuPage;

public class TC003 extends BaseTest
{
	@Test(description="Verify whether added Employee is Not Displayed In Employee List After Deleting")
	public void testEmployeeIsNotDisplayed()
	{
		HomePage hp = new HomePage(driver, webActionUtil);
		hp.clickOnMenu("pim");
		PIMMenuPage pim = new PIMMenuPage(driver, webActionUtil);
		pim.addEmployee("Neil", "Mukesh", "Nithin");
		Assert.assertEquals(pim.verifyEmployeeInEmployeeList("Shah"), true);
		pim.deleteEmployeeFromEmployeeList("Neil Mukesh");
		Assert.assertEquals(pim.verifyEmployeeInEmployeeList("Neil Mukesh"), false);
	}
}
