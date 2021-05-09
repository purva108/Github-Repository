package vtiger.GenericUtils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class WebDriverUtility 
{
	/**
	 * this method wait for 20 seconds for page loading
	 * @param driver
	 */

	public void waitUntilPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	}
	/*
	 * this method  wait element to be visible
	 * 
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch (Throwable e ) 
			{
				Thread.sleep(1000);
}	count++;
		}
		
	}

/**
 * 
 * @param element
 * @param index
 */
public void SelectOption(WebElement element, int index) 
{
	Select select= new Select(element);
	select.selectByIndex(index);
}
/**
 * 
 * @param element
 * @param option
 */

public void SelectOption(WebElement element, String option) 
{
	Select select= new Select(element);
	select.selectByVisibleText(option);
}
/**
 * this method will perform mouse hover action
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions act= new Actions(driver);
	act.moveToElement(element).perform();
	
}
/**
 * this method helps to switch from one window to another window
 * @param driver
 * @param partialWinTitle
 */

public void switchToWindow(WebDriver driver, String partialWinTitle)
{
	Set<String> window= driver.getWindowHandles();
	Iterator<String> it= window.iterator();
	while(it.hasNext())
	{
		String winId= it.next();
		driver.switchTo().window(winId);
	}
	
}
/**
 * accept alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
	
}
/**
 * cancel alert
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * this method performs right click operation
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions act= new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * this method used for scrolling action in a webpage
 * @param driver
 * @param element
 */
public void scrollToEWebElement(WebDriver driver, WebElement element) 
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	
}
public void switchFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);

}
public void switchFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);

}
public void switchFrame(WebDriver driver, String idOrName)
{
	driver.switchTo().frame(idOrName);

}

public void takeScreeshot(WebDriver driver, String screenshotName) throws Throwable
{
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	File dest= new File("./screenshot/"+screenshotName+".PNG");
	Files.copy(src, dest);
}
public void pressEnterKey(KeyEvent key) throws Throwable 
{
	Robot rc= new Robot();
	rc.keyPress(KeyEvent.VK_ENTER);
	rc.keyRelease(KeyEvent.VK_ENTER);
	
}
}	
	
