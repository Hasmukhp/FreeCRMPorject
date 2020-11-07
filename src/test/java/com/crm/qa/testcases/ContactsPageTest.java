package com.crm.qa.testcases;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
   LoginPage loginPage;
   HomePage  homePage;
   TestUtil testUtil;
   ContactsPage contactsPage;

   String sheetName="contacts";
   
  public ContactsPageTest()
 {
   super();
  }

 

@BeforeMethod
  public void setUp() throws InterruptedException
 {
   initialization();
   testUtil=new TestUtil();
   contactsPage=new ContactsPage();
   loginPage=new LoginPage();
  Thread.sleep(1000);
   homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
   testUtil.switchToFrame();
   contactsPage=homePage.clickOnContactsLink();  
 //  Thread.sleep(1000); 
}
 
 @Test(priority=1)
  public void verifyContactsPageLabel()
 {
  Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on the page");
  }
 
 
 @Test (priority=2)
  public void selectSingleContactsTest()
 
 {
  contactsPage.selectContactsByName("Test1 peter");
 }

 @Test(priority=3)
  public void selectMultipleContactsTest()
 {
  contactsPage.selectContactsByName("Test1 peter");
  contactsPage.selectContactsByName("Test1Hp Test");
   
   }


 @DataProvider
 public Object[][] getCRMTestData() throws Exception
 {
	Object data[][]=TestUtil.getTestData(sheetName);
     return data;	 
 }
 
 
 @Test(priority=4,dataProvider="getCRMTestData")
 public void validateCreateNewContact(String title,String firstName,String lastName,String company)
 {
 homePage.clickOnNewContactLink();
// contactsPage.createNewContact("Mr.", "janvi", "patel","yahoo");
 contactsPage.createNewContact(title,firstName,lastName,company);

 
}
 
   @AfterMethod
   public void tearDown()
   {
   driver.quit();
   }

}


