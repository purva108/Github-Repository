package vtigertest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vtiger.GenericUtils.BaseClass;

public class CreateOrganization extends BaseClass
{
	@Test
		public void createOrganization() throws Throwable 
		{
		 String orgName = eUtil.getExcelData("sheet1","TC_02", "organizationName");
		  
		    //navigate to organization
			driver.findElement(By.linkText("Organizations")).click();
			
			// navigate to create organization
			driver.findElement(By.xpath("//img[@title= 'Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName+ju.getRandomData());
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			// verification
	       String expData= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       //Assert.assertTrue(expData.contains(orgName));
	       SoftAssert asrt=new SoftAssert();
	       asrt.assertTrue(expData.contains(orgName));
	       System.out.println("expData");
}
}