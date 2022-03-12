package com.OneIndiaBank.PageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminBranchpage {
protected WebDriver local_driver;
	
	/*Constructor for mutual driver(also remember to make constructor 
	to public otherwise it cannot be accessed from other package )*/
	
	public AdminBranchpage(WebDriver remote_driver)
	{
		local_driver=remote_driver;
		PageFactory.initElements(remote_driver,this);
		
		AjaxElementLocatorFactory fact= new AjaxElementLocatorFactory(remote_driver, 30);
		PageFactory.initElements(fact,this);
	}
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement add_button;
	
//	@FindBy(name="bank_id")
//	WebElement select_bank;
	
	@FindBy(name = "branch_name")
	WebElement branch_name;
	
	@FindBy(name="address_line1")
	WebElement address_line1;
	
	@FindBy(name="address_line2")
	WebElement address_line2;
	
	@FindBy(name="address_line3")
	WebElement address_line3;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(name="pin_code")
	WebElement pin_code;
	
	@FindBy(name="phone_no")
	WebElement phone_number;
	
	@FindBy(name="email_id")
	WebElement email;
	
	@FindBy(name="ifsc")
	WebElement ifsc;
	
	@FindBy(name="micr_code")
	WebElement micr;
	
	@FindBy(name="headoffice_address")
	WebElement headoffice;
	
	@FindBy(name="submit")
	WebElement submit_btn;
	
	@FindBy(linkText = "ok")
	WebElement accept_btn;
	
	
	
	
	public void add_branch()
	{
		add_button.click();
		
	}
	
	
	public void add_branch_select_bank(String items)
	{
		WebElement Bank= local_driver.findElement(By.name("bank_id"));
		Select DropDownBank = new Select(Bank);
		List<WebElement> options = DropDownBank.getOptions();

		//Select By using getText
		try {
			for(WebElement option : options)
			{
				if(option.getText().equals(items))
				{
					DropDownBank.selectByVisibleText(items);
					break;
				}
			}
		}

		catch(Exception x)
		{
			System.out.println(x);
		}
	}
	
	
	
	public void add_branch_name(String name)
	{
		branch_name.clear();
		branch_name.sendKeys(name);
	}
	
	public void add_branch_address_line_1(String address1)
	{
		address_line1.clear();
		address_line1.sendKeys(address1);;
	}
	
	public void add_branch_address_line_2(String address2)
	{
		address_line2.clear();
		address_line2.sendKeys(address2);
	}
	
	public void add_branch_address_line_3(String address3)
	{
		address_line3.clear();
		address_line3.sendKeys(address3);
	}
	
	public void add_branch_city(String city_name)
	{
		city.clear();
		city.sendKeys(city_name);
	}
	
	public void add_branch_state(String state_name)
	{
		state.clear();
		state.sendKeys(state_name);
	}
	
	public void add_branch_country(String country_name)
	{
		country.clear();
		country.sendKeys(country_name);
	}
	
	public void add_branch_pincode(String pincode)
	{
		pin_code.clear();
		pin_code.sendKeys(pincode);
	}
	
	public void add_branch_phone_number(String phone) 
	{
		phone_number.clear();
		phone_number.sendKeys(phone);
	}
	
	public void add_branch_email(String mail) 
	{
		email.clear();
		email.sendKeys(mail);
	}
	
	
	public void add_branch_ifsc(String ifsc_code) 
	{
		ifsc.clear();
		ifsc.sendKeys(ifsc_code);
	}
	
	public void add_branch_micr_code(String micrcode)
	{
		micr.clear();
		micr.sendKeys(micrcode);
	}
	
	public void add_branch_head_office(String head_office_name)
	{
		headoffice.clear();
		headoffice.sendKeys(head_office_name);
	}
	
	public void add_branch_submit()
	{
		submit_btn.click();
	}
	
	public void add_branch_accept() 
	{
		accept_btn.click();	
	}
	
	
	
}
