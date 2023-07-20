package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.LoginPage;
import utilities.DataProviders;
import pageObjects.MyAccountPage;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="TestData" , dataProviderClass=DataProviders.class)
	public void test_LoginDDT(String username, String password, String data)
	{	
		logger.info("****   Started TC_003_LoginDDT   ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.click_Myaccount();
		hp.click_Login();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetPage=myacc.isMyAccountPageExists();
		
		if(data.equals("Valid")) {
			if(targetPage==true) {
				myacc.click_Logout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if(data.equals("Invalid")) {
			if(targetPage==true) {
				myacc.click_Logout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****   Finished TC_003_LoginDDT   ****");
	}

}
