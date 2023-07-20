package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"regression", "master"})
	public void test_Acc_Registration()
	{
		logger.debug(" *** Application Logs **** ");
		logger.info("*****   Starting TC_001_AccountRegistrationTest     *****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.click_Myaccount();
		logger.info( "Clicked on my account link");
		hp.click_Register();
		logger.info( "Clicked on my register link");
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		logger.info( "Providing customer data");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setPassword(randomAlphaNumeric());
		rp.click_Policybox();
		rp.click_Continue();
		logger.info( "Clicked on continue");
		
		String confmsg=rp.getConfirmationMsg();
		logger.info( "Validating Expected message");
		
		sf.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error( "Test Failed");
			Assert.fail();
		}
		
		logger.info("*****   Ended TC_001_AccountRegistrationTest     *****");
		
	}
	
	
	
	
}
