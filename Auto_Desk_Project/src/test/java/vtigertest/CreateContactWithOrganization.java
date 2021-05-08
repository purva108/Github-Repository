package vtigertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vtiger.GenericUtils.BaseClass;


public class CreateContactWithOrganization extends BaseClass
{
	 @Test
	 
	    public void contactwithorganization() throws Throwable {
	    
		
	       String orgName = eUtil.getExcelData("sheet1","TC_02", "organizationName");
	       String lastName = eUtil.getExcelData("sheet1","TC_02","lastName");
	     
		    //navigate to contact
			driver.findElement(By.linkText("Contacts")).click();
			
			//create contact with organization
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
			
			wUtil.switchToWindow(driver, "Accounts");
			driver.findElement(By.id("search_txt")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.linkText(orgName)).click();
			wUtil.switchToWindow(driver, "Contacts");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	    
	 		// sign out
		    WebElement administrator= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		    wUtil.mouseHover(driver,administrator);
		    wUtil.waitAndClick(driver.findElement(By.xpath("//a[text()='Sign Out']")));
			
		     
	         // close the browser
			 driver.close();
	 
}
}
