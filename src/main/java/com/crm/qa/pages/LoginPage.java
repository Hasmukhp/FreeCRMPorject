package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public  class LoginPage extends TestBase{
	//page factory-OR
	 @FindBy(name="username")
	  WebElement username;

	   @FindBy(name="password")
	   WebElement password;
	   
	  @FindBy(xpath="//input[@type='submit']")
	  WebElement loginBtn;
	  
	   @FindBy(xpath="//button[contain(text(),'Sign Up')]")
	   WebElement signUpBtn;

	    @FindBy(xpath="//img[contain(@class,'img-responsive')]")
	    WebElement crmLogo;

	public LoginPage(){
	 PageFactory.initElements(driver,this);
	}
	//Action:

	public String validateLoginPageTitle()
	{
	    return driver.getTitle();
	}

	

	public HomePage login(String un,String pwd)
	{
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.click();   
	return new HomePage();

	}
	

	
	}