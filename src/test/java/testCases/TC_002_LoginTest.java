package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups= {"sanity", "master"})
	public void test_AccountLogin()
	{
		logger.info("******      Starting TC_002_LoginTest       ******");
		
	try {	
	HomePage hp=new HomePage(driver);
	hp.click_Myaccount();
	logger.info("Clicked on MyAccount");
	hp.click_Login();
	logger.info("Clicked on Login");
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmailAddress(rb.getString("email"));
	logger.info("Entered email id");
	lp.setPassword(rb.getString("password"));
	logger.info("Entered password");
	lp.clickLogin();
	logger.info("Clicked on Login Button");
	
	MyAccountPage mp=new MyAccountPage(driver);
	boolean targetpage=mp.isMyAccountPageExists();
	sf.assertTrue(targetpage, "Login not successfull");
	sf.assertAll();
	} 
	catch(Exception e) {
		sf.fail();
	logger.info("Login failed");
	}	
	
	logger.info("******      Finished TC_002_LoginTest       ******");
	}
	
}
