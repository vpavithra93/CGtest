/* pavithra author
 * 
 */

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	
	   // @FindBy(xpath="//input[contains(text(),'pinky p')]")
		@FindBy(className="headertext")
		@CacheLookup
		WebElement usernamelabel;
		@FindBy(xpath="//a[contains(text(), 'Contacts')]")
		WebElement contactpage;
		@FindBy(xpath="//a[contains(text(), 'Deals)]")
		WebElement dealpage;
		@FindBy(xpath="//a[contains(text(), 'Tasks')]")
		WebElement taskpage;
		@FindBy(xpath="//a[text()='New Contact']")
		WebElement newcontact;
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
		public static String VerifyUsernameLabel() {
			return driver.getTitle();	
		}
		public ContactsPage ClickonContactspage() {
			contactpage.click();
			return new ContactsPage();
		}
		
		public DealsPage ClickonDealpage() {
			dealpage.click();
			return new DealsPage();
			
		}
			public  boolean Verifycorrectusername() {
				return usernamelabel.isDisplayed();
			}
				
			
	
		public TasksPage ClickonTaskpage() {
			taskpage.click();
			return new TasksPage();
		}
			public void clickonNewcontact() {
				Actions action=new Actions(driver);
						action.moveToElement(contactpage).build().perform();
						newcontact.click();
			}
				
			
	}

