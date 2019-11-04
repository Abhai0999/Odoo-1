package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;

public class SalesFeatures 
{
	CommonSteps cs;
	CustomerSteps cus;
	
	
	public SalesFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
		cus=new CustomerSteps(driver);
	}
	
	public void createNewCustomer(String[] customerData)
	{
		cs.clickCRM();
		cs.clickSales();
		cs.clickCustomers();
		cus.clickCreate();
		cus.createCustomer(customerData);
	}
	
	
	
	
	
	
	
	
	
	
	
}
