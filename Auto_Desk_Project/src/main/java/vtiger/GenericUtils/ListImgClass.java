package vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImgClass implements ITestListener
{
	
	public void onTestFailure(ITestResult result) {
		String currentDate= new Date().toString().replace(";","_").replace(" ","_");
		String failedTestName = result.getMethod().getMethodName();
		
		EventFiringWebDriver ed= new EventFiringWebDriver(BaseClass.sdriver);
		File srcImg = ed.getScreenshotAs(OutputType.FILE);
		File dstImg=new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		try {
			FileUtils.copyFile(srcImg, dstImg);
		}
		catch(IOException e) {
			
		}
}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
	