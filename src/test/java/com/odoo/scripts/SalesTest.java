package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest 
{
	@Test
	public void CreateCustomerTest()
	{
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.createCustomer(customerData);
	}
	
	@Test(priority=2)
	public void deleteCustomerTest() 
	{

		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "deleteCustomer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.deleteCustomer(customerData[3]);
	}
}