package vtigerSDET13;


import vtiger.GenericUtils.ExcelUtility;
import org.testng.annotations.Test;

public class GetData 
{
	    @Test
	    public void getData() throws Throwable {
		ExcelUtility eUtil= new ExcelUtility();
	    String value= eUtil.getExcelData("sheet1","TC_02","organizationName");
	    System.out.println(value);
}
}

