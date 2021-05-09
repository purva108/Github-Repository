package com.comcast.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtils.BaseClass;
import vtiger.contactpomclass.ContactInformationPage;
import vtiger.contactpomclass.ContactPage;
import vtiger.contactpomclass.CreateContactPage;
import vtiger.organizationpomclass.HomePage;


public class CreateContactWithOrganizationTest extends BaseClass
{
        @Test(groups="smokeTest")
	    public void createcontact() throws Throwable {
	    
		String lastName = eUtil.getExcelData("contact",1,3)+" "+ju.getRandomData();
	     
		    //navigate to contact
		    HomePage homePage=new HomePage(driver);
		    homePage.clickOnOrganizationLink();
			
			//create contact with organization
			ContactPage contactPage=new ContactPage(driver);
			contactPage.getCreateContactIMG();
			
			//verification
			ContactInformationPage contactInfoPage= new ContactInformationPage(driver);
			String actualContactText= contactInfoPage.getContactText();
			Assert.assertTrue(actualContactText.contains(lastName));
}
			
			
	
	     @Test(groups="regressionTest")
	      public void contactwithorganization() throws Throwable {
	    
		
	       String orgName = eUtil.getExcelData("contact",3,2)+" "+ju.getRandomData();
	       String lastName = eUtil.getExcelData("contact",3,3);
	     
		    //navigate to contact
	         HomePage homePage=new HomePage(driver);
		    homePage.clickOnOrganizationLink();
			
			
			//create contact with organization
		    ContactPage contactPage=new ContactPage(driver);
			contactPage.getCreateContactIMG();
			
			CreateContactPage createContactPage= new CreateContactPage(driver);
			createContactPage.createContactWithOrganization(lastName,orgName,"Accounts","Contacts");
			
			//verification
			ContactInformationPage contactInfoPage= new ContactInformationPage(driver);
			String actualContactText= contactInfoPage.getContactText();
		    Assert.assertTrue(actualContactText.contains(orgName));		
	    
}
}	

