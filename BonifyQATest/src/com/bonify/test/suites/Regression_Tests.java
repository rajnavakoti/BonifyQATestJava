package com.bonify.test.suites;

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

public class Regression_Tests {
	
	WebDriver driver;
	
	
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
	
	
	
	@Test (groups = {"Regression", "Positive"})
	public void TC_01_Verify_Login_With_Valid_Credentials() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_01_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_01_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(5000);
		WebElement UserName_Dropdown = driver.findElement(By.xpath(config.GetElementPath("Username_Menu_Dropdown_Xpath")));
		Assert.assertTrue(UserName_Dropdown.isDisplayed());
		Assert.assertEquals(UserName_Dropdown.getText(), "Rajashekar Navakoti");
		config.focus_on_element_and_Take_screenshot(UserName_Dropdown, "Reg_TC_01_Dashboard_Page");	
		
		LoginPage.Expand_Icon();
		LoginPage.Click_Signout_Button();		
	}	
	
	@Test (groups = {"Regression", "Negative"})	
	public void TC_02_Verify_Login_Without_Username() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_02_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(2000);
		
        String Username_Error_Message = driver.findElement(By.xpath(config.GetElementPath("UserName_Error_Xpath"))).getText();
        Assert.assertEquals(Username_Error_Message, "Trage bitte Deine Email-Adresse ein");			
	}	
	
	@Test (groups = {"Regression", "Negative"})
	public void TC_03_Verify_Login_With_Incorrect_Username() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_03_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_03_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(2000);
		
        String General_Error_Message = driver.findElement(By.xpath(config.GetElementPath("GeneralError_Xpath"))).getText();
        Assert.assertTrue(driver.findElement(By.xpath(config.GetElementPath("GeneralError_Xpath"))).isDisplayed());
        Assert.assertEquals(General_Error_Message, "Leider passen Benutzername und Passwort nicht zusammen.");			
	}	
	
	@Test (groups = {"Regression", "Negative"})
	public void TC_04_Verify_Login_With_Invalid_Email_Format() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_04_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_04_Password"));
		Thread.sleep(2000);
		
		String Username_Error_Message = driver.findElement(By.xpath(config.GetElementPath("UserName_Error_Xpath"))).getText();
        Assert.assertEquals(Username_Error_Message, "Bitte nutze eine gültige Email-Adresse");			
	}
	
	@Test (groups = {"Regression", "Negative"})
	public void TC_05_Verify_Login_Without_Password() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_05_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_05_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(2000);
		
		String Password_Error_Message = driver.findElement(By.xpath(config.GetElementPath("Password_Error_Xpath"))).getText();
        Assert.assertEquals(Password_Error_Message, "Trage bitte Dein Passwort ein");			
	}
	
	@Test (groups = {"Regression", "Negative"})
	public void TC_06_Verify_Login_Incorrect_Password() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_06_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_06_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(2000);
		
		String General_Error_Message = driver.findElement(By.xpath(config.GetElementPath("GeneralError_Xpath"))).getText();
        Assert.assertTrue(driver.findElement(By.xpath(config.GetElementPath("GeneralError_Xpath"))).isDisplayed());
        Assert.assertEquals(General_Error_Message, "Leider passen Benutzername und Passwort nicht zusammen.");
	}
	
	@Test (groups = {"Regression", "Negative"})
	public void TC_07_Verify_Login_Without_Username_Password() throws InterruptedException {		
		Login_Page LoginPage = new Login_Page(driver);
		General_Configurations config = new General_Configurations(driver);
		
		LoginPage.Enter_User_Name(config.GetTestData("Regression", "TC_07_User_Name"));
		LoginPage.Enter_Password(config.GetTestData("Regression", "TC_07_Password"));
		LoginPage.Click_Login_Button();
		Thread.sleep(2000);
		
		String Username_Error_Message = driver.findElement(By.xpath(config.GetElementPath("UserName_Error_Xpath"))).getText();
        Assert.assertEquals(Username_Error_Message, "Trage bitte Deine Email-Adresse ein");
        String Password_Error_Message = driver.findElement(By.xpath(config.GetElementPath("Password_Error_Xpath"))).getText();
        Assert.assertEquals(Password_Error_Message, "Trage bitte Dein Passwort ein");
	}
}
