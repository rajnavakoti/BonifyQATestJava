package com.bonify.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class General_Configurations {
	WebDriver driver;
	
	public General_Configurations(WebDriver driver) {
		this.driver = driver;
	}

	public String GetPropertyValue(String PropertyName)
	  {
		  
		String PropertyValue = null;
		 try {
				File src = new File ("./Configurations/BrowserConfig.Property");
				FileInputStream fis = new FileInputStream (src);
				Properties pro = new Properties();
				try {
					pro.load(fis);
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
			    PropertyValue = pro.getProperty(PropertyName);
				
				
			} catch (FileNotFoundException e) {
			
				System.out.println("Expection is "+e.getMessage());
			}
			return PropertyValue;		
	  }
	 
	 public String GetElementPath(String ElementName)
	  {
		  
		String ElementPathValue = null;
		 try {
				File src = new File ("./src/com/bonify/object/repository/ObjectRepo.property");
				FileInputStream fis = new FileInputStream (src);
				Properties pro = new Properties();
				try {
					pro.load(fis);
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
			    ElementPathValue = pro.getProperty(ElementName);
			 
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Expection is "+e.getMessage());
			}
		    
			return ElementPathValue;	
	  }
	
	 public void focus_on_element_and_Take_screenshot(WebElement ele, String ScreenshotName) {
		 ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", ele);
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(screenshot, new File("./Screenshots/"+ScreenshotName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, "");
	 }
	 
	 public void Take_Page_screenshot(String ScreenshotName) {
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    try {
				FileUtils.copyFile(screenshot, new File("./Screenshots/"+ScreenshotName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
	 }
	 
	 public String GetTestData(String type, String TestVariableName) {
		 String TestDataValue = null;
		 FileInputStream fis = null;
		 try {
				if (type=="General") {
			 	File src = new File ("./src/com/bonify/test/data/General.property");
			 	fis = new FileInputStream (src);
				}
			 	else if (type=="Smoke") {
			 	File src = new File ("./src/com/bonify/test/data/Smoke.property"); 
			 	fis = new FileInputStream (src);
				}
			 	else if (type=="Sanity") {
				File src = new File ("./src/com/bonify/test/data/Sanity.property"); 
				fis = new FileInputStream (src);
				}
			 	else if (type=="Regression") {
				File src = new File ("./src/com/bonify/test/data/Regression.property");
				fis = new FileInputStream (src);
				}

				Properties pro = new Properties();
				try {
					pro.load(fis);
				} catch (IOException e) {
					
					e.printStackTrace();
				}	
			    TestDataValue = pro.getProperty(TestVariableName);			
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Expection is "+e.getMessage());
			}
		    
			return TestDataValue;
	 }
	 
}



