package com.pageobject.googleaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.learnselenium.Constants;

public class GoogleAccountSignInPage {
	
	WebDriver driver;
	
	@FindBy(xpath = Constants.emailTextBox)
	public WebElement emailTextBox;
	
	@FindBy(xpath = Constants.createAccountLink)
	public WebElement createAccountLink;
	
	@FindBy(xpath = Constants.nextButton)
	public WebElement nextButton;
	
	public GoogleAccountSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//enter the email address 
	public boolean setEmailAddress(String value)
	{
		System.out.println("Enter Email Address :" + value);
		try {
			if(emailTextBox.isDisplayed())
				emailTextBox.sendKeys(value);
			System.out.println("Email Address entered :" + value);
		} catch (Exception e) {
			System.out.println("Email Address field not present on Sign In Page");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//click on CreateNewAccount
		public boolean isCreateAccountLinkClickable()
		{
			boolean flag = true;
			System.out.println("Verifing if 'Create account Link' is clickable");
			try {
				if(createAccountLink.isEnabled())
					createAccountLink.click();
				Thread.sleep(4000);
				driver.navigate().back();
				System.out.println("Clicked on 'Create account' link and verified its clickable");
			    return flag;	
			} catch (Exception e) {
				flag = false;
			}
			return flag;
		}
		
	//click on CreateNewAccount
	public boolean clickOnCreateAccountLink()
	{
		System.out.println("Clicking on 'Create account Link' ");
		try {
			if(createAccountLink.isDisplayed())
				createAccountLink.click();
			System.out.println("Clicked on 'Create account' link");
			} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	

}
