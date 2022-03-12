package com.OneIndiaBank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLoginPage {

protected WebDriver local_driver;
	
	public CustomerLoginPage(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
		AjaxElementLocatorFactory fact= new AjaxElementLocatorFactory(remote_driver, 30);
		PageFactory.initElements(fact,this);
	}
	
	
	@FindBy(partialLinkText="Customer")
	WebElement customer_button;
	
	@FindBy(name="username")
	@CacheLookup
	private WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	private WebElement login_btn;
	
	
	@FindBy(xpath="//input[@value='Logout']")
	@CacheLookup
	private WebElement logout_btn;
	
	
	
	
	public void navigate_to_customer_page()
	{
		customer_button.click();
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
	}
	
	
	
	
}
