package com.OneIndiaBank.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OneIndiaBank.PageObjects.AdminBranchEditpage;
import com.OneIndiaBank.PageObjects.AdminLoginPage;
import com.OneIndiaBank.PageObjects.Adminpanelpage;

public class TC_AdminEditBranch_003 extends BaseClass{
	
	
	@Test
	public void Update_Branch_details() throws Exception
	{
		
		AdminLoginPage login= new AdminLoginPage(driver);
		
		
		
		login.navigate_to_admin_page();
		
		login.login_button();

		Adminpanelpage nav = new Adminpanelpage(driver);

		Thread.sleep(3000);
//		WebElement setup =driver.findElement(By.partialLinkText("Setup"));
//		Actions hover =new Actions(driver);
//		hover.moveToElement(setup).perform();
		

		nav.navigate_to_setup();
		
		
		
		
		driver.findElement(By.partialLinkText("Branch")).click();
		
		AdminBranchEditpage update=new AdminBranchEditpage(driver);
		update.update_branch(5);
		
		
		switchtonewwindow();
		
		update.add_branch_select_bank("Gringotts WB");

		update.add_branch_name(" Gringotts of The Mystic Grill");
		update.add_branch_address_line_1("Route 66");
		update.add_branch_address_line_2("Mystic Falls");
		Thread.sleep(2000);
		update.add_branch_address_line_3("Hamilton");
		Thread.sleep(2000);
		update.add_branch_city("Hamilton");
		update.add_branch_state("Edinburgh");
		
		update.add_branch_country("Scotland");
		
		String Random_pin_code = randomnumber(6);
		update.add_branch_pincode(Random_pin_code);
		
		String Random_phone_number = randomnumber(10);
		update.add_branch_phone_number(Random_phone_number);

		String Random_Email_id = randomAlphanumeric(7);
		update.add_branch_email(Random_Email_id + "@gmail.com");

		String Random_Ifsc_code = randomnumber(16);
		update.add_branch_ifsc(Random_Ifsc_code);

		String Random_micr_code = randomnumber(9);
		update.add_branch_micr_code(Random_micr_code);

		update.add_branch_head_office("London, England");

		update.add_branch_submit();
		

		//validation
		boolean result = driver.getPageSource().contains("No of rec successfully:1");

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
		
		Thread.sleep(3000);
		
		update.add_branch_accept();
		
		
		
		
	}

}
