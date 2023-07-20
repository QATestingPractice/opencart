package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="input-firstname")
	WebElement txt_FirstName;
	
	@FindBy(id="input-lastname")
	WebElement txt_LastName;
	
	@FindBy(id="input-email")
	WebElement txt_Email;
	
	@FindBy(id="input-password")
	WebElement txt_Password;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement chkbx_Policy;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btn_Submit;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement msg_confirmation;
	
	public void setFirstName(String firstname)
	{
		txt_FirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		txt_LastName.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	public void click_Policybox()
	{
		chkbx_Policy.click();
	}
	
	public void click_Continue()
	{
		btn_Submit.click();
	}
	
	public String getConfirmationMsg()
	{
		try{
		return(msg_confirmation.getText());
		} catch(Exception e) {
			return(e.getMessage());
		}
	}
}
