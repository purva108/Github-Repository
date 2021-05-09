package com.comcast.crm.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import vtiger.GenericUtils.BaseClass;
import vtiger.organizationpomclass.CreateOrganizationPage;
import vtiger.organizationpomclass.HomePage;
import vtiger.organizationpomclass.OrganizationInformationPage;
import vtiger.organizationpomclass.OrganizationPage;

public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="smokeTest")
		public void createOrganization() throws Throwable 
		{
		 String orgName = eUtil.getExcelData("org",1,2)+" "+ju.getRandomData();
		  
		    //navigate to organization
		   HomePage homePage=new HomePage(driver);
			homePage.clickOnOrganizationLink();
			
			
			// navigate to create organization
			OrganizationPage orgPage= new OrganizationPage(driver);
			orgPage.clickOnCreateOrganizationIMG();
			
			CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
			createOrgPage.createOrganization(orgName);
			
			// verification
			OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
			String actualOrgName= orgInfoPage.getOrganizationText();
			Assert.assertTrue(actualOrgName.contains(orgName));
	       
}
	
	@Test(groups="regressionTest")
	public void createIndustry() throws Throwable 
	{
		
        String industryType = eUtil.getExcelData("org",4,3 )+" "+ju.getRandomData();
        String orgName = eUtil.getExcelData("org",4, 2);
		
		// navigate to organization
        HomePage homePage=new HomePage(driver);
		homePage.clickOnOrganizationLink();
		
		// create organization
		OrganizationPage orgPage= new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();
		
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName);
		
		//verification
		OrganizationInformationPage orgInfoPage=new OrganizationInformationPage(driver);
		String actualOrgName= orgInfoPage.getOrganizationText();
		Assert.assertTrue(actualOrgName.contains(orgName));
		String  actualIndustryType= orgInfoPage.getIndustryText();
		Assert.assertEquals(actualIndustryType, industryType);
		
		
	}
}