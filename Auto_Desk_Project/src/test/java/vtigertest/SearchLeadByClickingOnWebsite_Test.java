package vtigertest;

import org.testng.annotations.Test;

import vtiger.GenericUtils.BaseClass;
import vtiger.leadpomclass.CreateLeadPage;
import vtiger.leadpomclass.HomePage;
import vtiger.leadpomclass.SearchLeadPage;


public class SearchLeadByClickingOnWebsite_Test extends BaseClass {

	@Test
	public void creatWebsite() throws Throwable
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
	
	CreateLeadPage createlead=new CreateLeadPage(driver);
	createlead.createLeadMethod(firstname, lastname, company, phone, email, website);
	createlead.LeadSaveMethod();
	
	homepage.LeadlistMethod();
	
	SearchLeadPage searchlead=new SearchLeadPage(driver);
	searchlead.SearchleadMethod();
		            
	searchlead.getSearchbarTF().sendKeys("www.testyantrass.com");
    wUtil.SelectOption(searchlead.getSearcharDropdown(), "Website");
		         
    searchlead.SubmitSearch();
		         
		       
	}
}


