package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
{
	@Test()
	public void createCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_customer_ID",4);
		
		String[] customerData = eu.readData("Sheet1","create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.createCustomer(customerData);	
	}
	
	@Test(dependsOnMethods= {"createOpportunity"})
	public void deleteCustomer() 
	{ 
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "create_customer_ID");
		
		lf.login(customerData[1],customerData[2]);
		sf.deleteCustomer(customerData);
	}
	
	@Test(dependsOnMethods= {"newCustomer"})
	public void createOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_opportunity_ID", 4);
		
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		
		String[] customerData=eu.readData("sheet1", "create_customer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.createOpportunity(opportunityData, customerData);
		
	}
	
	@Test(dependsOnMethods= {"createOpportunity"})
	public void drgAndDrpOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_opportunity_ID", 4);
		
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		
		String[] customerData=eu.readData("sheet1", "create_customer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.dragAnOpportunity(opportunityData);
	}
}