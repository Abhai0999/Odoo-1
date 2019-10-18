package com.odoo.scripts;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.odoo.features.SalesFeature;
import com.odoo.features.VerifyNewCustFeature;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
{
	@Test(priority=1)
	public void newCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		
		lf.login(customerData[1], customerData[2]);	
		sf.createNewCustomer(customerData);
		//lf.verifyValidLogin(data[1]);
		//cf.commonEle();
		
//		SalesFeature csf=new SalesFeature(driver);
//		csf.clickCreateBtn();		
//		
//		NewCustomerFeature ncf=new NewCustomerFeature(driver);		
//		ncf.createCustomer(data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]);		
		
//		NewCustomerSteps ncs=new NewCustomerSteps(driver);
//		String value = ncs.custName(data[3]);
		//VerifyNewCustFeature vncf=new VerifyNewCustFeature(driver);
		//vncf.verifyNewCustomer(data[3], data[3]);
		
	}
	
	@Test(enabled=false)
	public void dltNewCustomer()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		
		lf.login(customerData[1], customerData[2]);
		String[] customerData1 = eu.readData("Sheet1", "deletecustomer_ID");

		sf.dltNewCustomer(customerData1);
	}
}
