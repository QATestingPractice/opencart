package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public SoftAssert sf;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"sanity", "regression", "master"})
	@Parameters("browser")
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass()); 
		sf=new SoftAssert();
		rb=ResourceBundle.getBundle("config");
		 
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String randomNumber()
	{
		return RandomStringUtils.randomNumeric(5);
	}
	
	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return st+"#"+num;
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";

		try
		{
		FileUtils.copyFile(src, new File(dest));
		} catch(Exception e) {
			e.getMessage();
		}
		return dest;
	
	}
	
	@AfterClass(groups= {"sanity", "regression", "master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
