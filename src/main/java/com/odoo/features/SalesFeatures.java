package com.odoo.features;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;
import com.odoo.steps.PipelineSteps;

public class SalesFeatures 
{

 CommonSteps cs;
 CustomerSteps cts;
 PipelineSteps ps;
 
 public SalesFeatures(WebDriver driver)
 {
	 
	 cs=new CommonSteps(driver);
	 cts=new CustomerSteps(driver);
	 ps=new PipelineSteps(driver);
 }
 public void  createCustomer(String customerName,String[] customerData,String exepath)
 {
	 cs.clickOnCRM();
	 cs.clickOnSales();
	 cs.clickOncustomers();
	 cts.clickOnCreate();
	 cts.createCustomer(customerName,customerData, exepath);
	 cts.clickOnSave();
	
 }
 
 public void verifyCreateCustomer(String customerName)
 {
	 cts.verifyCustText(customerName);
	 cts.verifyCustTitle(customerName);
	 Reporter.log(customerName+" Customer create Successfully done",true);
 }
 public void deleteCustomer(String customerName)
	{
	 cs.clickOnCRM();
	 cs.clickOnSales();
	 cs.clickOncustomers();
	cts.TotalCustomers(customerName);
	cts.clickOnActions();
	}
 public void verifyDeleteCustomer(String customerName)
 {
	 cts.verifyDeleteCustTitle(customerName);
	 cs.clickOnSales();
	 cs.clickOncustomers();
	 cts.verifyDeleteCustName(customerName);
 }
 public void createOpportunity(String oppName,String expRevenue,String customerName)
 {
	 cs.clickOnCRM();
	 ps.clickOnCreate();
	 ps.createOppotunity(oppName,expRevenue,customerName);
	
 }
 public void verifyOpportunity(String opptName)
 {
     ps.veriOppoNames(opptName);
 }
 
 
 
 
}
