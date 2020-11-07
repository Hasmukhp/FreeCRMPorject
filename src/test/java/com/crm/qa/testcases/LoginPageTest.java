package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

//import org.testng.annotations.AfterMethod;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
    LoginPage loginPage;
    HomePage   homePage;  

	
public LoginPageTest()
  {
   super(); 
  } 
  
  
@BeforeMethod

   public void setUp()
   {
    initialization();
     loginPage = new LoginPage(); 
    
    }
    
   @Test(priority=1 )
   public void loginPageTitleTest() throws InterruptedException
   {
	   
   String title= loginPage.validateLoginPageTitle();
   
   System.out.println("Page title--->"+title);
   
   Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");   
   
   }
      
 
    @Test(priority=2)
    public void loginTest() throws InterruptedException
   {
    	Thread.sleep(1000);
    homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }    

 @AfterMethod
    public void teardown()
    {
    driver.quit();  
    System.out.println("browser quit");
    }  

}