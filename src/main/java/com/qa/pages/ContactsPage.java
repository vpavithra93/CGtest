package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
		
	@FindBy(className="datacardtitle")
	WebElement contactslabel;
	@FindBy(name="first_name")
	WebElement firstname;
	@FindBy(name="surname")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement companyname;
	@FindBy(className="button")
	WebElement savebtn;
	public ContactsPage() {
	PageFactory.initElements(driver, this);
	}
     public boolean VerifyContactlabel() {
	return contactslabel.isDisplayed();
       }
     public void selectcontactsByname(String name){
    	 driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
     }
     
     public void createnewcontact(String title, String ftname, String Ltname, String comp) {
  	 Select S=new Select(driver.findElement(By.name("title")));
    	
  	   S.selectByVisibleText(title);
  	   firstname.sendKeys(ftname);
  	   lastname.sendKeys(Ltname);
  	   companyname.sendKeys(comp);
  	     savebtn.submit();
     }
	}


