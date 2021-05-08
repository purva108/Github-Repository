package vtigertest;

import org.testng.annotations.Test;

import vtiger.GenericUtils.BaseClass;
import vtiger.leadpomclass.CreateLeadPage;
import vtiger.leadpomclass.HomePage;
import vtiger.leadpomclass.SearchLeadPage;

public class SearchLeadBYClickingOnAssigned_Test extends BaseClass
{

	@Test
	public void creatLead() throws Throwable
	{
	
		/**
		 * this method is use to read data from json file
		 */
		String firstname = fUtil.getDataFromJson("firstname");
		String lastname = fUtil.getDataFromJson("lastname");
		String company = fUtil.getDataFromJson("company");
		String phone = fUtil.getDataFromJson("phone");
		String email = fUtil.getDataFromJson("email");
		String website = fUtil.getDataFromJson("website");
		
		//step-4 : navigating to lead page
		
		HomePage homepage=new HomePage(driver);
		homepage.LeadlistMethod();
        
		CreateLeadPage createleadpage=new CreateLeadPage(driver);
		
		createleadpage.createLeadMethod(firstname, lastname, company, phone, email, website);
		createleadpage.LeadSaveMethod();
		  
	
		   homepage.LeadlistMethod();
		
		 SearchLeadPage searchpage=new SearchLeadPage(driver);
		 searchpage.SearchleadMethod();
		 searchpage.getSearchbarTF().sendKeys("administrator");
		         wUtil.SelectOption(searchpage.getSearcharDropdown(), "Assigned To");
		         
		    searchpage.SubmitSearch();
	}
}


