package com.qa.testclasses;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utility.TestUtil;

public class ContactspageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="Sheet1";
	public ContactspageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		Initialization();
		testutil=new TestUtil();
		loginpage= new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switctoframe();
		contactspage=homepage.ClickonContactspage();
	}
	
	@Test()
	public void verifycontactsLabel() {
		Assert.assertTrue(contactspage.VerifyContactlabel(),"contact label is missing on the page");
	}
	@Test()
	public void selectsinglecontactTest() {
		contactspage.selectcontactsByname("pavithra v");
	}
	@Test()
	public void selectMultiplecontactTest() {
		contactspage.selectcontactsByname("pavithra v");
		contactspage.selectcontactsByname("monky p");
	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]= TestUtil.getTestData(sheetname);
		return data;
	}
	@Test(dataProvider="getCRMTestData", enabled=false)
   public void ValidateCreatecontact(String title, String ftname, String Ltname, String comp) {
		homepage.clickonNewcontact();
		//contactspage.createnewcontact("Miss", "pallavi", "v", "MNC");
		contactspage.createnewcontact(title, ftname, Ltname, comp);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
}


