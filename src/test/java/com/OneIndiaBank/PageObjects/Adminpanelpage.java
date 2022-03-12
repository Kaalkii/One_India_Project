package com.OneIndiaBank.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminpanelpage {
	
protected WebDriver local_driver;
//Creating object of an Actions class
Actions action = new Actions(local_driver);
	
	/*Constructor for mutual driver(also remember to make constructor 
	to public otherwise it cannot be accessed from other package )*/
	
	public Adminpanelpage(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
		AjaxElementLocatorFactory fact= new AjaxElementLocatorFactory(remote_driver, 30);
		PageFactory.initElements(fact,this);
	}


	By setup_btn= By.partialLinkText("Setup");
	
	By bank_btn=By.partialLinkText("Bank");
	
	By branch_btn=By.partialLinkText("Branch");
	
	By customer_btn = By.partialLinkText("Customer");
	
	
		
	
	//This Element leads to setup DropDown 
//	@FindBy(partialLinkText = "Setup")
//	@CacheLookup
//	static
//	WebElement setup_btn;
//	
//	@FindBy(partialLinkText = "Bank")
//	@CacheLookup
//	WebElement bank_btn;
//	
//	@FindBy(partialLinkText = "Branch")
//	@CacheLookup
//	WebElement branch_btn;
//	
//	@FindBy(partialLinkText = "Customer")
//	@CacheLookup
//	WebElement customer_btn;
	
	
	public void navigate_to_setup()
	{
//		WebElement s_btn=local_driver.findElement(setup_btn);
		WebElement s_btn=local_driver.findElement(By.partialLinkText("Setup"));
		
		s_btn.click();
		
//		try {
//		WebDriverWait wait = new WebDriverWait(local_driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Setup")));
//		action.moveToElement(s_btn).perform();
//		}
//		catch(Exception x)
//		{
			
//		}
	}
	
//	public static WebElement getWebElement()
//    {
//        try {
//			return setup_btn;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return setup_btn;
//    }
//	
//	public void navi_to_setup()
//	{
//		WebElement button = new WebDriverWait(local_driver, 20).until(ExpectedConditions.elementToBeClickable(Adminpanelpage.getWebElement()));
//        new Actions(local_driver).moveToElement(button).click().perform();
//	}
	
	
	
	public void navigate_to_Branch()
	{
		navigate_to_setup();
		WebElement Bnch_btn=local_driver.findElement(branch_btn);
		local_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Bnch_btn.click();
		
	}
	
	public void navigate_to_Bank()
	{
		
		navigate_to_setup();
		WebElement Bnk_btn=local_driver.findElement(bank_btn);
		local_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Bnk_btn.click();
		
	}
	
	public void navigate_to_Customer()
	{
		navigate_to_setup();
		WebElement Ctr_btn=local_driver.findElement(customer_btn);
		local_driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Ctr_btn.click();
		
	}
	
	
	
	
	
}
