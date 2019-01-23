package com.qa.testclasses;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
public void setUP() {
		Initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=loginpage.ValidateLoginPageTitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest() {
		Boolean flag=loginpage.validateCRMlogo();
		Assert.assertTrue(flag);
	}
    
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
