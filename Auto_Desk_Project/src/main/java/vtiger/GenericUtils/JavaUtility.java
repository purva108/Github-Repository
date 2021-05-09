package vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

public class JavaUtility 
{
	/*
	 * generate random number
	 * @Purva
	 */
	@Test
	public String getRandomData() 
	{
		Random random= new Random();
		int ran= random.nextInt(1000);
		return ""+ran;
		
	}
	/**
	 * Generate current system date
	 * @ Purva
	 * 
	 */
	public String getCurrentSystemDate() 
	{
		Date date= new Date();
		String currentdate= date.toString();
		return currentdate;
		
		
	}
}
