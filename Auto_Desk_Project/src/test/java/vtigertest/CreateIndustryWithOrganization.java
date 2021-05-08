package vtigertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vtiger.GenericUtils.BaseClass;


public class CreateIndustryWithOrganization extends BaseClass
{
	@Test
	public void createIndustry() throws Throwable 
	{
		
        String industryType = eUtil.getExcelData("sheet1",5, 3);
        String orgName = eUtil.getExcelData("sheet1",3, 2);
		
		// navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// create organization
		driver.findElement(By.xpath("//img[@title= 'Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+ju.getRandomData());
		
		// select finance from industry drop down
		//Select sel= new Select(driver.findElement(By.name("industry")));
		//sel.selectByVisibleText("Finance");
	
		WebElement industry=driver.findElement(By.name("industry"));
		wUtil.SelectOption(industry, industryType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
}
}
