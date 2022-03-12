package com.OneIndiaBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.OneIndiaBank.PageObjects.AdminBranchpage;
import com.OneIndiaBank.PageObjects.AdminLoginPage;
import com.OneIndiaBank.PageObjects.Adminpanelpage;


public class TC_AdminAddBranch_002 extends BaseClass{

	
	
	
	@Test 
	public void addingBranch() throws Exception {
		
		AdminLoginPage login= new AdminLoginPage(driver);
		
		
		
		login.navigate_to_admin_page();
		
		login.login_button();


		Thread.sleep(3000);
//		WebElement setup =driver.findElement(By.partialLinkText("Setup"));
//		Actions hover =new Actions(driver);
//		hover.moveToElement(setup).perform();
//		driver.findElement(By.partialLinkText("Branch")).click();
		
		
		Adminpanelpage gotobranch= new Adminpanelpage(driver);
		gotobranch.navigate_to_setup();
		gotobranch.navigate_to_Branch();
		

	       
		AdminBranchpage adbrnch= new AdminBranchpage(driver);
		adbrnch.add_branch();
		
		switchtonewwindow();
		
		adbrnch.add_branch_select_bank("Gringotts WB");

		adbrnch.add_branch_name(" Gringotts of The Mystic Grill");
		adbrnch.add_branch_address_line_1("Route 66");
		adbrnch.add_branch_address_line_2("Mystic Falls");
		Thread.sleep(2000);
		adbrnch.add_branch_address_line_3("Hamilton");
		Thread.sleep(2000);
		adbrnch.add_branch_city("Hamilton");
		adbrnch.add_branch_state("Edinburgh");
		
		adbrnch.add_branch_country("Scotland");
		
		String Random_pin_code = randomnumber(6);
		adbrnch.add_branch_pincode(Random_pin_code);
		
		String Random_phone_number = randomnumber(10);
		adbrnch.add_branch_phone_number(Random_phone_number);

		String Random_Email_id = randomAlphanumeric(7);
		adbrnch.add_branch_email(Random_Email_id + "@gmail.com");

		String Random_Ifsc_code = randomnumber(16);
		adbrnch.add_branch_ifsc(Random_Ifsc_code);

		String Random_micr_code = randomnumber(9);
		adbrnch.add_branch_micr_code(Random_micr_code);

		adbrnch.add_branch_head_office("London, England");

		adbrnch.add_branch_submit();
		

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
		
		adbrnch.add_branch_accept();



	        
	
	}
	
	
	

}

