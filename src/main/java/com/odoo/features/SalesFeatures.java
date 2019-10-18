package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;

public class SalesFeatures 
{

 CommonSteps cs;
 CustomerSteps cts;
 
 public SalesFeatures(WebDriver driver)
 {
	 
	 cs=new CommonSteps(driver);
	 cts=new CustomerSteps(driver);
 }
 public void  createCustomer(String customerName,String[] customerData,String exepath)
 {
	 cs.clickOnCRM();
	 cs.clickOnSales();
	 cs.clickOncustomers();
	 cts.createCustomer(customerName,customerData, exepath);
 }
 public void deleteCustomer(String customerName)
	{
	 cs.clickOnCRM();
	 cs.clickOnSales();
	 cs.clickOncustomers();
	 cts.deleteCustomer(customerName);
	}
}
