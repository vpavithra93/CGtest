package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

// page factory or PR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement loginButton;
	@FindBy(xpath="//a[href='https://www.freecrm.com/register/']")
	WebElement signup;
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmlogo;
	
	//Intializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMlogo(){
		return crmlogo.isDisplayed();
	}
	public HomePage login(String  un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginButton.submit();
		return new HomePage();
	}
	
	
}
