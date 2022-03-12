package com.OneIndiaBank.TestCases;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.OneIndiaBank.PageObjects.AdminLoginPage;
import com.OneIndiaBank.utilities.XLUtils;


public class TC_AdminloginTestDDT_001 extends BaseClass {



	@Test(dataProvider = "LoginData")

	//This method will receive two String from retrieveData() method mentioned below
	public void loginDDT(String XLusername, String XLpassword) throws InterruptedException {

		//Calling  AdminLoginPage present in com.OneIndiaBank.PageObjects package
		AdminLoginPage lp= new AdminLoginPage(driver);


		lp.navigate_to_admin_page();


		
		lp.setUsername(XLusername);
		logger.info("user name provided");
		lp.setPassword(XLpassword);
		logger.info("password provided");
		lp.login_button();
		
		Thread.sleep(3000);
		lp.logout_button();
	
//		if(isAlertPresent(driver)==true)
//		{
//			WebDriverWait wait = new WebDriverWait(driver, 2);
//	        wait.until(ExpectedConditions.alertIsPresent());
//	        Alert alert = driver.switchTo().alert();
//	        alert.accept();
//			driver.switchTo().defaultContent();
//			Assert.assertTrue(false);
//			logger.warn("login failed");
//		}
//		else
//		{
//			Assert.assertTrue(true);
//			logger.info("login passed");
//			lp.logout_button();
//			driver.switchTo().alert().accept();/// close logout alert
//			driver.switchTo().defaultContent();
//		}

	}




	@DataProvider(name="LoginData")
	String [][] retrieveData() throws IOException
	{

		String path= System.getProperty("user.dir") + "/src/test/java/com/OneIndiaBank/testData/LoginData.xlsx";

		int rownum= XLUtils.getRowCount(path,"Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String [rownum][colcount];

		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); /////1 0
			}
		}

		return logindata;
	}



}
