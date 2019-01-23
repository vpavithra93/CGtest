package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utility.TestUtil;
import com.qa.utility.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\pavithra\\eclipse-workspace\\CGtest\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void Initialization() {
			String browsername=prop.getProperty("browser");
			if(browsername.equals("chrome"))
			{
				String Key="webdriver.chrome.driver";
				String value="C:\\Users\\pavithra\\Desktop\\selenium\\chromedriver.exe";
			        System.setProperty(Key, value); 
				driver = new ChromeDriver();
			}
			else if(browsername.equals("FF"))
			{
				String Key="webdriver.gecko.driver";
				String value="C:\\Users\\pavithra\\Desktop\\selenium\\geckodriver.exe";
			        System.setProperty(Key, value); 
				driver= new FirefoxDriver();
			}
			
			EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
			WebEventListener eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver=e_driver;
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_Timeout,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		 driver.get(prop.getProperty("Url"));
}
}
