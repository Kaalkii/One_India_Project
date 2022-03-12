package com.OneIndiaBank.TestCases;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.OneIndiaBank.utilities.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	ReadConfig readconfig = new ReadConfig();

	//Calling functions of ReadConfig Class present in com.OneIndiaBank Package 
	public String baseURL = readconfig.getBrowserURL();
	public String Admin_username = readconfig.get_admin_Username();
	public String Admin_password = readconfig.get_admin_Password();
	public String Customer_username = readconfig.get_Customer_Username();
	public String Customer_password = readconfig.get_Customer_Password();


	public static WebDriver driver; 
	public static Logger logger;


	//Passing parameter for desired Browser
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) 
	{


		logger = Logger.getLogger("OneIndiaBanking");
		PropertyConfigurator.configure("Log4j.properties");


		if(br.equalsIgnoreCase("chrome"))
		{	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
			
		}

		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}


		//Launching WebSite of ONEINDIABANK
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("URL is opened");

	}


	//This will close the Browser
	@AfterClass
	public void teardown() 
	{
		driver.close();
		driver.quit();
	}






	//This method is for taking Screenshot 
	public void captureScreen(WebDriver driver, String methodname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+ "/Screenshot/" + methodname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	} 

	//Fetching the Title of WebPage
	public void fetchTitle(String ExpectedTitle, String methodname) throws Exception
	{
		if(driver.getTitle().equals(ExpectedTitle))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
		}
		else
		{
			captureScreen(driver, methodname);
			System.out.println("Title of Page is : " + driver.getTitle());
			Assert.assertTrue(false);
			logger.info("Login Test failed");
		}
	}



	//User defined method to check weather Alert is Present or Not
	public boolean isAlertPresent(WebDriver driver)
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException x)
		{
			return false;
		}
	}

	//Method for Generating Random Alphabets
	public String randomstring(int length)
	{
		String generatedString = RandomStringUtils.randomAlphabetic(length);
		return(generatedString);
	}


	//Method for Generating Random Numbers
	public static String randomnumber(int length)
	{
		String generatedStringInNumber= RandomStringUtils.randomNumeric(length);
		return (generatedStringInNumber);
	}


	//Method for Generating Random AlphaNumeric
	public static String randomAlphanumeric(int length)
	{
		String generateStringInAplhanumeric=RandomStringUtils.randomAlphanumeric(length);
		return generateStringInAplhanumeric;
	}

	//Method to Switch to New Window
	public static void switchtonewwindow()
	{
		try {
			Thread.sleep(3000);
			for(String winHandle: driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
			}
		}
			catch (Exception e) {
				System.out.println(e);
			}
	}
}
