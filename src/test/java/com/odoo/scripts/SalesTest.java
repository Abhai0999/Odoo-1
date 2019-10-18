package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest  extends BaseAbstractTest
{
	SeleniumLib sl;
	@Test(priority=1)
	public void newCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "create_customer_ID");
		
		lf.login(customerData[1], customerData[2]);
		
		sf.createNewCust(customerData);	
	}
	
	@Test(priority=2)
	public void deleteCustomer() 
	{ 
		sl=new SeleniumLib(driver);
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "delete_customer_ID");
		
		lf.login(customerData[1], customerData[2]);
		sl.iSleep(5);
		sf.deleteCust(customerData[3]);
	}
}
