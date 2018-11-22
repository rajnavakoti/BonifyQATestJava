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


public class Smoke_Tests {
	
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
	
	
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case asserts the Title of the web page "bonify" */
	public void TC_01_Verify_Page_Titile() {	
		General_Configurations config = new General_Configurations(driver);
			
		Assert.assertEquals(driver.getTitle(), config.GetTestData("General", "Login_Page_Title")); 
	}
	
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies whether Header Text is displayed with the expected text value "Willkommen bei bonify!" */
	public void TC_02_Verify_HeaderText() {
		General_Configurations config = new General_Configurations(driver);
		WebElement HeaderText = driver.findElement(By.xpath(config.GetElementPath("Header_Text_Xpath")));
		
	    
		Assert.assertTrue(HeaderText.isDisplayed()); /* Verify Header Text is displayed*/
	    Assert.assertEquals(HeaderText.getText(), "Willkommen bei bonify!");  /* Verify Header Text is displayed*/
	    
	    config.focus_on_element_and_Take_screenshot(HeaderText, "TC_02_HeaderText_Field.png");
	}
	

	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies user name text field is dispalyed, editable and with default text "Email / Benutzername" */
	public void TC_03_Verify_UserName_Field() {
		General_Configurations config = new General_Configurations(driver);
		WebElement UserName = driver.findElement(By.xpath(config.GetElementPath("Username_Xpath")));
		WebElement UserNameLabel = driver.findElement(By.xpath(config.GetElementPath("Username_Label_Xpath")));
		
		Assert.assertTrue(UserName.isDisplayed());
		Assert.assertTrue(UserName.isEnabled());
		config.focus_on_element_and_Take_screenshot(UserName, "TC_03_UserName_Field.png");
		
		Assert.assertTrue(UserNameLabel.isDisplayed());
		Assert.assertEquals(UserNameLabel.getText(), "Email / Benutzername");
		config.focus_on_element_and_Take_screenshot(UserNameLabel, "TC_03_UserName_Label.png");	    
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies password text field is dispalyed, editable and with default text "Passwort" */
	public void TC_04_Verify_Password_Field() {
		General_Configurations config = new General_Configurations(driver);
		WebElement Password = driver.findElement(By.xpath(config.GetElementPath("Password_Xpath")));
		WebElement PasswordLabel = driver.findElement(By.xpath(config.GetElementPath("Password_Label_Xpath")));
		
		Assert.assertTrue(Password.isDisplayed());
		Assert.assertTrue(Password.isEnabled());
		config.focus_on_element_and_Take_screenshot(Password, "TC_04_Password_Field.png");
		
		Assert.assertTrue(PasswordLabel.isDisplayed());
		Assert.assertEquals(PasswordLabel.getText(), "Passwort");
		config.focus_on_element_and_Take_screenshot(PasswordLabel, "TC_04_Password_Label.png");	    
	}

	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies forgot password link is dispalyed, enabled and with the text "Passwort Vergessen?" */
	public void TC_05_Verify_Forgot_Password_Link() {
		General_Configurations config = new General_Configurations(driver);
		WebElement ForgotPasswordLink = driver.findElement(By.xpath(config.GetElementPath("ForgotPasswordlink_Xpath")));
		
		Assert.assertTrue(ForgotPasswordLink.isDisplayed());
		Assert.assertTrue(ForgotPasswordLink.isEnabled());
		Assert.assertEquals(ForgotPasswordLink.getText(), "Passwort vergessen?");
		config.focus_on_element_and_Take_screenshot(ForgotPasswordLink, "TC_05_ForgotPassword_Link.png");
		 
	}

	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies Login Button is dispalyed, enabled and with the text "ANMELDUNG" */
	public void TC_06_Verify_Login_Button() {
		General_Configurations config = new General_Configurations(driver);
		WebElement LoginButton = driver.findElement(By.xpath(config.GetElementPath("LoginButton_Xpath")));
		
		Assert.assertTrue(LoginButton.isDisplayed());
		Assert.assertTrue(LoginButton.isEnabled());
		Assert.assertEquals(LoginButton.getText(), "ANMELDUNG");
		config.focus_on_element_and_Take_screenshot(LoginButton, "TC_06_Login_Button.png");
		 
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies Register Button is dispalyed, enabled and with the text "NUE REGISTRIEREN" */
	public void TC_07_Verify_Register_Button() {
		General_Configurations config = new General_Configurations(driver);
		WebElement RegisterButton = driver.findElement(By.xpath(config.GetElementPath("RegisterButton_Xpath")));
		
		Assert.assertTrue(RegisterButton.isDisplayed());
		Assert.assertTrue(RegisterButton.isEnabled());
		Assert.assertEquals(RegisterButton.getText(), "NEU REGISTRIEREN");
		config.focus_on_element_and_Take_screenshot(RegisterButton, "TC_07_Register_Button.png");
		 
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies Impressum Link is dispalyed, enabled and with the text "Impressum" */
	public void TC_08_Verify_impressum_Link() {
		General_Configurations config = new General_Configurations(driver);
		WebElement ImpressumLink = driver.findElement(By.xpath(config.GetElementPath("ImpressumLink_Xpath")));
		
		Assert.assertTrue(ImpressumLink.isDisplayed());
		Assert.assertTrue(ImpressumLink.isEnabled());
		Assert.assertEquals(ImpressumLink.getText(), "Impressum");
		config.focus_on_element_and_Take_screenshot(ImpressumLink, "TC_08_Impressum_Link.png");
		 
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies AGB Link is dispalyed, enabled and with the text "AGB" */
	public void TC_09_Verify_AGB_Link() {
		General_Configurations config = new General_Configurations(driver);
		WebElement AGBLink = driver.findElement(By.xpath(config.GetElementPath("AGBLink_Xpath")));
		
		Assert.assertTrue(AGBLink.isDisplayed());
		Assert.assertTrue(AGBLink.isEnabled());
		Assert.assertEquals(AGBLink.getText(), "AGB");
		config.focus_on_element_and_Take_screenshot(AGBLink, "TC_09_AGBLink_Link.png");
		 
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies Datenschutz Link is dispalyed, enabled and with the text "Datenschutz" */
	public void TC_10_Verify_Datenschutz_Link() {
		General_Configurations config = new General_Configurations(driver);
		WebElement DatenschutzLink = driver.findElement(By.xpath(config.GetElementPath("DatenschutzLink_Xpath")));
		
		Assert.assertTrue(DatenschutzLink.isDisplayed());
		Assert.assertTrue(DatenschutzLink.isEnabled());
		Assert.assertEquals(DatenschutzLink.getText(), "Datenschutz");
		config.focus_on_element_and_Take_screenshot(DatenschutzLink, "TC_10_DatenschutzLink_Link.png");
		 
	}
	
	@Test (groups = {"Smoke", "UI"})
	/* This Test case Verifies Footer Text is displayed with the text "Für die Sicherheit Deiner Daten arbeitet bonify mit:" */
	public void TC_11_Verify_Footer_Text() {
		General_Configurations config = new General_Configurations(driver);
		WebElement FooterText = driver.findElement(By.xpath(config.GetElementPath("FooterText_Xpath")));
		
		Assert.assertTrue(FooterText.isDisplayed());
		Assert.assertTrue(FooterText.isEnabled());
		Assert.assertEquals(FooterText.getText(), "Für die Sicherheit Deiner Daten arbeitet bonify mit:");
		config.focus_on_element_and_Take_screenshot(FooterText, "TC_11_Footer_Text.png");
		 
	}

}
