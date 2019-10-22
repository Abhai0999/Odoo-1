package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
{
	@Test()
	public void newCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData("Sheet1", 2, 3);
		
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1], customerData[2]);		
		sf.createNewCustomer(customerData);		
		String[] customerName = eu.readData("Sheet1", "createCustomer_ID");		  
		sf.verifyNewCustomer(customerName[3], customerName[3]);
		 
	}
	
	@Test(dependsOnMethods= {"newCustomer"})
	public void dltNewCustomer()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1], customerData[2]);
		String[] customerData1 =eu.readData("Sheet1", "createCustomer_ID");
		sf.dltNewCustomer(customerData1);
		sf.verifyDltCustomer(customerData1);
		
	}

}
