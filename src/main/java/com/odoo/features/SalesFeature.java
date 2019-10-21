package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomersSteps;

public class SalesFeature 
{

	CustomersSteps cus;
	CommonSteps cs;
	SeleniumLib sl;
	
	
	
	
	public SalesFeature(WebDriver driver)
	{
		
		cus=new CustomersSteps(driver);
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
		
	}
	
	public void createNewCustomer(String[] customerData)
	{
		cs.clickCrm();
		cs.clickSales();
		cs.clickCust();
		cus.clickCreate();
		cus.createCustomer(customerData);
	}
	
	public void verifyNewCustomer(String userName,String custName)
	{
		cus.VerifyNewCustomer(userName, custName);
	}
	
	
	
	public void dltNewCustomer(String[] customerData1 )
	{
		
		cs.clickCrm();
		cs.clickSales();
		cs.clickCust();
		cus.dltCustomer(customerData1);
	}
	
	public void verifyDltCustomer(String[] expextedCust )
	{
		cus.verifyDltCustomer(expextedCust);
	}
	
	
	
	
	
}