package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver) {
		super(driver);
	}
		
	//WebElements
	 @FindBy(xpath="//span[text()='My Account']") 
	 WebElement lnk_Myaccount;
	 
	 @FindBy(xpath="//li/a[text()='Register']")
	 WebElement lnk_Register;
	 
	 @FindBy(xpath="//li/a[text()='Login']")
	 WebElement lnk_Login;
	 
	 //Action Methods
	 public void click_Myaccount()
	 {
		 lnk_Myaccount.click();
	 }
	 
	 public void click_Register()
	 {
		 lnk_Register.click();
	 }
		
	 public void click_Login()
	 {
		 lnk_Login.click();
	 }	
		
		
}
