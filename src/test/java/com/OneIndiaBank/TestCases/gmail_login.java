package com.OneIndiaBank.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class gmail_login extends BaseClass{
	
	
	
	
	@Test
	public void gmailSignup()
	{
	
		
		String Random_pin_code = randomnumber(6);
		
		
		String Random_phone_number = randomnumber(10);
		

		String Random_Email_id = randomAlphanumeric(7);
		

		String Random_Ifsc_code = randomnumber(16);
		

		String pass = randomnumber(9);
		
	driver.findElement(By.name("firstName")).sendKeys("Tony");
	System.out.println("First Name" + "Tony");
	
    driver.findElement(By.name("lastName")).sendKeys("Stark");
	System.out.println("Last Name" + "Stark");
    
    driver.findElement(By.name("Username")).sendKeys(Random_Email_id);
    System.out.println(Random_Email_id + "@gmail.com");
    
    driver.findElement(By.name("Passwd")).sendKeys(pass);
    System.out.println("Password " + pass);
    
    driver.findElement(By.name("ConfirmPasswd")).sendKeys(pass);
    
    driver.findElement(By.id("i3")).click();
    
    driver.findElement(By.xpath("//span[text()='Next']")).click();
    
    
	
	}
}
