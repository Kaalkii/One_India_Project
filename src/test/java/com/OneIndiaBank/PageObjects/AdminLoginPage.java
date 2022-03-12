package com.OneIndiaBank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
	
	protected WebDriver local_driver;
	
	/*Constructor for mutual driver(also remember to make constructor 
	to public otherwise it cannot be accessed from other package )*/
	
	public AdminLoginPage(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
		AjaxElementLocatorFactory fact= new AjaxElementLocatorFactory(remote_driver, 30);
		PageFactory.initElements(fact,this);
	}
	
	//This Element leads to Administrator login panel from HomePage 
	@FindBy(partialLinkText = "Admin")
	private WebElement Admin_button;
	
	
	//This Element is for UserName Box in Administrator login panel 
	@FindBy(name="username")
	@CacheLookup
	private WebElement txtUsername;
	
	//This Element is for Password Box in Administrator login panel
	@FindBy(name="password")
	@CacheLookup
	private WebElement txtPassword;
	
	
	//This Element is for Login_Button in Administrator login panel
	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	private WebElement login_btn;
	
	
	//This Element is for Login_Button in Administrator DashBoard
	@FindBy(xpath="//input[@value='Logout']")
	private WebElement logout_btn;
	
	
	public void navigate_to_admin_page()
	{
		Admin_button.click();
		WebDriverWait wait = new WebDriverWait(local_driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		local_driver.switchTo().alert().accept();
		local_driver.switchTo().defaultContent();
	}
	
	
	public void setUsername(String username)
	{
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void login_button() {
		login_btn.click();
	}
	
	public void logout_button() {
		logout_btn.click();
		WebDriverWait wait = new WebDriverWait(local_driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
//		local_driver.switchTo().alert().accept();
//		local_driver.switchTo().defaultContent();
	}
	
	

}
