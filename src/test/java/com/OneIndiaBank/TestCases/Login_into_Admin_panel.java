package com.OneIndiaBank.TestCases;

import org.testng.annotations.Test;
import com.OneIndiaBank.PageObjects.AdminLoginPage;


public class Login_into_Admin_panel extends BaseClass{


	AdminLoginPage login;

	@Test
	public void loginTestforAdmin() throws Exception
	{	
		
		//creation of object of AdminLoginPage present in com.OneIndiaBank.PageObjects
		login= new AdminLoginPage(driver);
		
		
		//calling methods of AdminLoginPage present in com.OneIndiaBank.PageObjects
		Thread.sleep(3000);
		login.navigate_to_admin_page();

		Thread.sleep(3000);
		login.setUsername(Admin_username);
		logger.info("Entered Username");
		
		Thread.sleep(3000);
		login.setPassword(Admin_password);
		logger.info("Entered Password");
		
		Thread.sleep(3000);
		login.login_button();

		fetchTitle("One India bank", "loginTestforAdmin");

	}

}
