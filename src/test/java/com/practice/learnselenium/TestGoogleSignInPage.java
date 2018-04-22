package com.practice.learnselenium;

import org.testng.annotations.Test;

import com.pageobject.googleaccount.GoogleAccountSignInPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestGoogleSignInPage {
	
  WebDriver driver;
  
  GoogleAccountSignInPage signInPage;
  
  @BeforeTest
  public void beforeTest() {
	  //create Driver
	  /*System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") +  "\\src\\main\\resources\\geckodriver.exe");
	  driver = new FirefoxDriver();*/
	  
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\src\\main\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver.get(Constants.url);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	  
  }
  
  @Test
  public void verifyElementsOnSignInPage()
  {
	  Assert.assertTrue(signInPage.isCreateAccountLinkClickable(), "Create account' link is not clickable");
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Before Method of Test method executed");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("After Method of Test method executed");
  }

  

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class method executed");
	  driver.close();
  }

  

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest method executed at the end of all tests");
	  driver.quit();
  }

}
