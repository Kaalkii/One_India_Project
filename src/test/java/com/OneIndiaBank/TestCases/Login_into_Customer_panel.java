package com.OneIndiaBank.TestCases;

import org.testng.annotations.Test;
import com.OneIndiaBank.PageObjects.CustomerLoginPage;

public class Login_into_Customer_panel extends BaseClass{
	
	CustomerLoginPage login;
	
	@Test
	public void loginTestforCustomer() throws Exception
	{	
		
		//creation of object of CustomerLoginPage present in com.OneIndiaBank.PageObjects
		login= new CustomerLoginPage(driver);
		
		
		//calling methods of CustomerLoginPage present in com.OneIndiaBank.PageObjects
		Thread.sleep(3000);
		login.navigate_to_customer_page();

		Thread.sleep(3000);
		login.setUsername(Customer_username);
		logger.info("Entered Username");
		
		Thread.sleep(3000);
		login.setPassword(Customer_password);
		logger.info("Entered Password");
		
		Thread.sleep(3000);
		login.login_button();

		fetchTitle("One India bank", "loginTestforCustomer");

	}

}
