package com.practice.learnselenium;

import org.testng.annotations.Test;

import com.pageobject.googleaccount.GoogleAccountSignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestGoogleSignInPage {
	
  WebDriver driver;
  
  
  GoogleAccountSignInPage signInPage;
  
  @SuppressWarnings("deprecation")
@BeforeTest
  public void beforeTest() {
	  //create Driver
	  /*System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") +  "\\src\\main\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();*/
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\src\\main\\resources\\chromedriver.exe");
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--incognito");
	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	  driver = new ChromeDriver(capabilities);
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class executed once");
  }
  
  @Test
  public void signInToYourGoogleAccount() {
	  
	  signInPage = new GoogleAccountSignInPage(driver);
	  
	  //Verify if email Text box is present 
	  String email = "soumyajit443@gmail.com";
	  
	  signInPage.setEmailAddress(email);
	  Assert.assertTrue(
			  signInPage.emailTextBox.getAttribute("data-initial-value").equals(email),
			  "Failed since Actual email = " + signInPage.emailTextBox.getAttribute("data-initial-value")
			  + " and Expected email = " + email);
	  //Click on Next button
	  signInPage.clickNextBtn();
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOf(signInPage.passwordTextBox));
	  
	  //Enter the password
	  String password = "0601212444";
	  signInPage.setPassword(password);
	  
	  //Click on Next Button
	  signInPage.clickNextBtn();
	  
	  //Verify the error message
	  Assert.assertTrue(signInPage.isIncorrectPwdErrorMsgDisplayed(), "Error message should get displayed for incorrect password entered");
	  
	  String expectedErrorMsg = "Wrong password. Try again or click Forgot password to reset it.";
	  Assert.assertEquals(signInPage.getIncorrectPwdErrorMsg(), expectedErrorMsg, "Actual Error message = " + signInPage.getIncorrectPwdErrorMsg() 
	  + "which do not get displayed for incorrect password");
	  
	  
  }
  
  @Test
  public void verifyElementsOnSignInPage()
  {
	  Assert.assertTrue(signInPage.isCreateAccountLinkClickable(), "Create account' link is not clickable");
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Before Method of Test method executed");
	  
	  driver.get(Constants.url);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("After Method of Test method executed");
	  //driver.close();
  }

  

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class method executed");
	  
  }

  

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest method executed at the end of all tests");
	  driver.quit();
  }

}
