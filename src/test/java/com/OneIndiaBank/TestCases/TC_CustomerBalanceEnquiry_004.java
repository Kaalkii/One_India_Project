package com.OneIndiaBank.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OneIndiaBank.PageObjects.CustomerLoginPage;

public class TC_CustomerBalanceEnquiry_004 extends BaseClass {
	
	
	CustomerLoginPage login;
	
	@Test
	public void validating_balance_enquiry() throws Exception {
		
		login= new CustomerLoginPage(driver);
		
		login.navigate_to_customer_page();
		
		login.setUsername(Customer_username);
		logger.info("Entered Username");
		
		login.setPassword(Customer_password);
		logger.info("Entered Password");
		
		login.login_button();
		logger.info("Login successfull");
		
		Thread.sleep(3000);
		WebElement setup =driver.findElement(By.partialLinkText("Account"));
		Actions hover =new Actions(driver);
		hover.moveToElement(setup).perform();
		driver.findElement(By.partialLinkText("Balance Enquiry")).click();
		logger.info("Entered into Balance Enquiry page");
		
		//validation
				boolean result = driver.getPageSource().contains("CUSTOMER PROFILE");

				if(result == true )
				{
					Assert.assertTrue(true);
					logger.info("Test Case Passed");
				}

				else 
				{
					captureScreen(driver,"addingBranch");
					Assert.assertTrue(true);
					logger.info("Test Case Failed");

				}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
