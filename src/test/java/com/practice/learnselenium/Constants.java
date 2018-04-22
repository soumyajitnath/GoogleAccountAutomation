package com.practice.learnselenium;

public class Constants {
	
	  public static final String url = "https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	  public static final String CHOOSE_AN_ACCOUNT_AREA = "//ul[@class='sIznTe pggQ5e']";
	  public static final String LIST_OF_ACCOUNTS = "//li[@class='C5uAFc w6VTHd']";
	  
	  public static final String emailTextBox = "//input[@type='email']";
	  public static final String createAccountLink = "//span[text()='Create account']";
	  public static final String nextButton = "//span[text()='Next']";
	  public static final String passwordTextBox = "password";//name
	  public static final String incorrectPwdErrMsg = "//div[@jsname='B34EJ'][contains(text(),'Wrong')]";//xpath

}
