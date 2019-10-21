package com.odoo.scripts;

import org.testng.annotations.Test;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
{
 @Test
 public void createCustomer()
 {
	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	 String exepath=GenericLib.dir+"/resource/upld.exe";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String customerName = eu.readAndWriteData("Sheet1", "createCustomer_ID",3);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.createCustomer(customerName,customerData, exepath);
 }
 @Test(dependsOnMethods ="createCustomer")
 public void deleteCustomer()
 {
	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	 ExcelUtilities eu=new ExcelUtilities(filepath);
	 String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.deleteCustomer(customerData[3]);
		sf.verifyDeleteCustomer(customerData[3]);
 }
 @Test(priority=2)
 public void createOpportunity()
 {
	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	 ExcelUtilities eu=new ExcelUtilities(filepath);
	 String oppName = eu.readAndWriteData("sheet1", "createOpportunity_ID", 3);
	 String customerName = eu.readAndWriteData("sheet1", "createOpportunity_ID", 4);
	String[] oppData = eu.readData("sheet1", "createOpportunity_ID");
	lf.login(oppData[1], oppData[2]);
	sf.createOpportunity(oppName,oppData[5],customerName);
	sf.verifyOpportunity(oppName);
 }
 
}
