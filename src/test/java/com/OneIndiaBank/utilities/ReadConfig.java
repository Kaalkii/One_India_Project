package com.OneIndiaBank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File source = new File("./Configurations/config.properties");

		try {
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception x)
		{
			System.out.println("Exception is" + x.getMessage());
		}
	}
	
	
	

	public String getBrowserURL()
	{
		String url= pro.getProperty("baseURL");
		return url;
	}

	public String get_admin_Username()
	{
		String admin_username=pro.getProperty("admin_username");
		return admin_username;
	}
	
	
	public String get_admin_Password()
	{
		String admin_password=pro.getProperty("admin_password");
		return admin_password;
	}
	
	public String get_Customer_Username()
	{
		String customer_Username=pro.getProperty("customer_username");
		return customer_Username;
	}
	
	public String get_Customer_Password()
	{
		String customer_password=pro.getProperty("customer_password");
		return customer_password;
	}
	
	public String getChrome()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getEdge() 
	{
		String edge= pro.getProperty("edgepath");
		return edge;
		
	}
	
	public String getFox()
	{
		String firefox= pro.getProperty("firefoxpath");
		return firefox;
	}
	
	




}
