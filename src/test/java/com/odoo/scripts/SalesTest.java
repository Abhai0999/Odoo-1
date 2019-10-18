package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest  extends BaseAbstractTest
{
	@Test()
	public void newCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_customer_ID");
		
		String[] customerData = eu.readData("Sheet1","create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.createNewCust(customerData);	
	}
	
	@Test(dependsOnMethods= {"newCustomer"})
	public void deleteCustomer() 
	{ 
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "create_customer_ID");
		
		lf.login(customerData[1],customerData[2]);
		sf.deleteCust(customerData);
	}
}
