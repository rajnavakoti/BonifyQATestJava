package com.bonify.page.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bonify.configurations.General_Configurations;

public class Login_Page {
	
	static WebDriver driver;

	public Login_Page(WebDriver driver) {
		
		Login_Page.driver = driver;		
	}
	

	General_Configurations config = new General_Configurations(driver);
	
    By HeaderText = By.xpath(config.GetElementPath("Header_Text_Xpath"));
    By UserName = By.xpath(config.GetElementPath("Username_Xpath"));
    By Password = By.xpath(config.GetElementPath("Password_Xpath"));
    By ForgotPasswordLink = By.xpath(config.GetElementPath("ForgotPasswordlink_Xpath"));
    By LoginButton = By.xpath(config.GetElementPath("LoginButton_Xpath"));
    By RegisterButton = By.xpath(config.GetElementPath("RegisterButton_Xpath"));
    By ImpressumLink = By.xpath(config.GetElementPath("ImpressumLink_Xpath"));
    By AGBLink = By.xpath(config.GetElementPath("AGBLink_Xpath"));
    By DatenschutzLink = By.xpath(config.GetElementPath("DatenschutzLink_Xpath"));
    By FooterText = By.xpath(config.GetElementPath("FooterText_Xpath"));
    By ExpandIcon = By.xpath(config.GetElementPath("Expand_Icon_At_User_ID_Xpath"));
    By SignoutButton = By.xpath(config.GetElementPath("Signout_Button_Xpath"));
         
	
    public void Enter_User_Name(String Expected_Text) {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(UserName));
	driver.findElement(UserName).clear();
	driver.findElement(UserName).sendKeys(Expected_Text);
		
	}

    public void Enter_Password(String Expected_Text) {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(Password));
	driver.findElement(Password).clear();
	driver.findElement(Password).sendKeys(Expected_Text);
		
	}
    
    public void Click_On_Forgot_Password_Link() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(ForgotPasswordLink));
	driver.findElement(ForgotPasswordLink).click();;
		
	}
    
    public void Click_Login_Button() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
	driver.findElement(LoginButton).click();;
		
	}
    
    public void Click_Register_Button() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(RegisterButton));
	driver.findElement(RegisterButton).click();;
		
	}
    
    public void Click_Impressum_Link() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(ImpressumLink));
	driver.findElement(ImpressumLink).click();;
		
	}
    
    public void Click_AGB_Link() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(AGBLink));
	driver.findElement(AGBLink).click();;
		
	}
    
    public void Click_Datenschutz_Link() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(DatenschutzLink));
	driver.findElement(DatenschutzLink).click();;
		
	}
    
    public void Expand_Icon() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(ExpandIcon));
	driver.findElement(ExpandIcon).click();;
		
	}
    
    public void Click_Signout_Button() {
		
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(SignoutButton));
	driver.findElement(SignoutButton).click();;
		
	}
}
