# BonifyQATestRobot
  
## Purpose of this project is to automate 'bonify' web application using selenium tool and robot test framework.
   Test suite includes 11 smoke test cases, 6 Sanity Test Cases, 7 Regression test cases and 1 test case for optional task 3
   covering testing for 'my.bonify.de' login fucntionality
   Robot framework will provide logs, reports and output execution files
   Screenshots are included in the project screenshots folder

### Automation Specifications ###
 Application : My.bonify.de (Web App)
 Automation Tool : Selenium
 Test Framework : TestNG
 Supporting language : Java

### Required Tools ###
 Java -For supporting language
 Selenium - For web app automation
 TestNG - For Testing framework (TDD Framework)
 
### Guide for installation ###
 1.Java installation
  a.Download and install Java from https://www.java.com/en/download/
  b.Add environment varaibles for Java
 2.Install TestNG framework
 3.Download geckodriver from https://github.com/mozilla/geckodriver/releases
   Add geckodriver.exe path to system environment variables
  
 
### Script execution Details ###
 1. Test cases are categeorized into Sanity, Smoke and Regression
 2. Run the revelvant .xml files in 'BonifyQATest' folder using TestNG 


### Execution File and Output specifications ###
 Base Test Execution Files : BonifyQATestJava/BonifyQATest/Sanity.xml; 
                             BonifyQATestJava/BonifyQATest/Smoke.xml; 
							 BonifyQATestJava/BonifyQATest/Regression.xml; 
 Path for Log File : BonifyQATestJava/BonifyQATest/log.html
 Path for Reports : BonifyQATestJava/BonifyQATest/index.html
 Path for Screesnhotst : BonifyQATestJava/BonifyQATest/Screenshots

