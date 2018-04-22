package com.pageobject.googleaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.learnselenium.Constants;

public class GoogleAccountSignInPage {
	
    public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = Constants.emailTextBox)
	public WebElement emailTextBox;
	
	@FindBy(xpath = Constants.createAccountLink)
	public WebElement createAccountLink;
	
	@FindBy(xpath = Constants.nextButton)
	public WebElement nextButton;
	
	@FindBy(name = Constants.passwordTextBox)
	public WebElement passwordTextBox;
	
	@FindBy(xpath = Constants.incorrectPwdErrMsg)
	public WebElement incorrectPwdErrorMsg;
	
	public GoogleAccountSignInPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
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
	
	public void setPassword(String value)
	{
		if(passwordTextBox.isDisplayed())
			passwordTextBox.sendKeys("rinku_09");
	}
	
	public void clickNextBtn(){
		if(nextButton.isEnabled())
			nextButton.click();
		System.out.println("Clicked on 'Next' button");
	}
	
	public boolean isIncorrectPwdErrorMsgDisplayed()
	{
		return incorrectPwdErrorMsg.isDisplayed();
	}
	public String getIncorrectPwdErrorMsg()
	{
		return incorrectPwdErrorMsg.getText();
	}
	
	

}
