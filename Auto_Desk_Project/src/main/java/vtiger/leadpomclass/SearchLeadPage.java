package vtiger.leadpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchLeadPage {
 WebDriver driver;
 
 @FindBy(xpath = "(//input[@name='search_text'])[1]")
 private WebElement searchbarTF;
 
 @FindBy(id = "bas_searchfield")
 private WebElement searcharDropdown;
 
 @FindBy(xpath = "(//input[@name='submit'])[1]")
 private WebElement submitBTN;
 
 public SearchLeadPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }

public WebElement getSearchbarTF() {
	return searchbarTF;
}

public WebElement getSearcharDropdown() {
	return searcharDropdown;
}

public WebElement getSubmitBTN() {
	return submitBTN;
}
 public void SearchleadMethod() {
	 searchbarTF.click();

 }
 public void SubmitSearch() {
	 submitBTN.click();
 }
}
