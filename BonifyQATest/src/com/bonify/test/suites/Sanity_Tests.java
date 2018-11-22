package com.bonify.test.suites;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.bonify.configurations.General_Configurations;
import com.bonify.page.actions.Login_Page;

public class Sanity_Tests {
	
	static WebDriver driver;

	
	@BeforeSuite
	public void Suite_Setup() {	
		General_Configurations config = new General_Configurations(driver);
		
		String browser = config.GetPropertyValue("Browser");
		 String URL = config.GetPropertyValue("URL");
		 
		 if(browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", config.GetPropertyValue("GeckDriver"));
			 driver = new FirefoxDriver();
		 }
		 else if (browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("Webdriver.chrome.driver",config.GetPropertyValue("ChormeDriver"));
			 driver = new ChromeDriver();
		 }
		 else if (browser.equalsIgnoreCase("ie")) {
			 System.setProperty("Webdriver.chrome.driver",config.GetPropertyValue("IEDriver"));
			 driver = new ChromeDriver();
		 }		 
		 driver.get(URL);
	 }
	
	
	
	@Test (groups = {"Sanity", "Positive"})
	/* This Test verifies the basic positive login functionality */
	public void TC_01_Verify_Login_With_Valid_Credentials() throws InterruptedException {	
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Sanity", "TC_01_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Sanity", "TC_01_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(4000);
		WebElement UserName_Dropdown = driver.findElement(By.xpath(config.GetElementPath("Username_Menu_Dropdown_Xpath")));
		Assert.assertTrue(UserName_Dropdown.isDisplayed());
		Assert.assertEquals(UserName_Dropdown.getText(), "Rajashekar Navakoti");
		config.focus_on_element_and_Take_screenshot(UserName_Dropdown, "TC_01_Dashboard_Page");	
		
		LoginPage.Expand_Icon();
		LoginPage.Click_Signout_Button();
		
	}
	
	@Test (groups = {"Sanity", "Positive"})
	
	public void TC_02_Verify_Forgot_Password_Navigation_From_LoginPage() throws InterruptedException {		

		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		driver.get(config.GetPropertyValue("URL"));
		
		LoginPage.Click_On_Forgot_Password_Link();
		Thread.sleep(4000);
		String Navigated_Page_url = driver.getCurrentUrl();
		Assert.assertEquals(Navigated_Page_url, "https://my.bonify.de/recover/send-email");
		config.Take_Page_screenshot("TC_02_Password_Reset_Page");		
	}
	
	@Test (groups = {"Sanity", "Positive"})
	public void TC_03_Verify_Registration_Navigation_From_LoginPage() throws InterruptedException {		
		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		driver.get(config.GetPropertyValue("URL"));
		
		LoginPage.Click_Register_Button();
		
		Thread.sleep(4000);
		String Navigated_Page_url = driver.getCurrentUrl();
		Assert.assertEquals(Navigated_Page_url, "https://my.bonify.de/register/email");
		config.Take_Page_screenshot("TC_03_Registration_Page");					
	}
	
	@Test (groups = {"Sanity", "Positive"})
	public void TC_04_Verify_Impressum_Navigation_From_LoginPage() throws InterruptedException {	
		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		driver.get(config.GetPropertyValue("URL"));
	
		LoginPage.Click_Impressum_Link();
		Thread.sleep(5000);
	    Set<String> windowhandles = driver.getWindowHandles();
	    int windows = windowhandles.size();
	    System.out.println(windows);
	    String window2 = (String) windowhandles.toArray()[1];
	    System.out.println(window2);
	    driver.switchTo().window(window2);
		
	    String Navigated_Page_url = driver.getCurrentUrl();
		Assert.assertEquals(Navigated_Page_url, "https://www.bonify.de/impressum");
		config.Take_Page_screenshot("TC_04_Impressum_Page");	
		driver.switchTo().window((String) windowhandles.toArray()[0]);
	}
	
	@Test (groups = {"Sanity", "Positive"})
	public void TC_05_Verify_AGB_Navigation_From_LoginPage() throws InterruptedException {	
		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		driver.get(config.GetPropertyValue("URL"));
		
		LoginPage.Click_AGB_Link();
		Thread.sleep(5000);
		Set<String> windowhandles = driver.getWindowHandles();
		int windows = windowhandles.size();
		System.out.println(windows);
		String window2 = (String) windowhandles.toArray()[1];
		System.out.println(window2);
		driver.switchTo().window(window2);
		
		String Navigated_Page_url = driver.getCurrentUrl();
		Assert.assertEquals(Navigated_Page_url, "https://www.bonify.de/agb");
		config.Take_Page_screenshot("TC_05_AGB_Page");	
		driver.switchTo().window((String) windowhandles.toArray()[0]);
	}
	
	@Test (groups = {"Sanity", "Positive"})
	public void TC_06_Verify_Datenschutz_Navigation_From_LoginPage() throws InterruptedException {	
		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		driver.get(config.GetPropertyValue("URL"));
		
		LoginPage.Click_Datenschutz_Link();
	    Thread.sleep(5000);
		Set<String> windowhandles = driver.getWindowHandles();
		int windows = windowhandles.size();
		System.out.println(windows);
		String window2 = (String) windowhandles.toArray()[1];
		System.out.println(window2);
		driver.switchTo().window(window2);
		
		String Navigated_Page_url = driver.getCurrentUrl();
		Assert.assertEquals(Navigated_Page_url, "https://www.bonify.de/datenschutz");
		config.Take_Page_screenshot("TC_06_Datenschutz_Page");	
		driver.switchTo().window((String) windowhandles.toArray()[0]);
}
}
