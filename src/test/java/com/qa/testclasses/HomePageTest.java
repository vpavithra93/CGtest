package com.qa.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	
   public HomePageTest() {
	   super();
   }
	
	@BeforeMethod
	public void SetUp() {
		Initialization();
		testutil=new TestUtil();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void HomepagetitleTest()
	{
   String title=HomePage.VerifyUsernameLabel();
   Assert.assertEquals(title, "CRMPRO", "Not matched");
	}
	
	@Test(priority=2)
	public void VerigyusernameTest() {
		testutil.switctoframe();
		Assert.assertTrue(homepage.Verifycorrectusername());
	}
	@Test(priority=3)
	public void ClickoncontactsTest() {
		testutil.switctoframe();
		homepage.ClickonContactspage();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
