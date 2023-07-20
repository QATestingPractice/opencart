package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);	}

	@FindBy(id="input-email")
	WebElement txt_EmailAddress;

	@FindBy(id="input-password")
	WebElement txt_Password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement btn_Login;
	
	public void setEmailAddress(String email)
	{
		txt_EmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}
	
}
