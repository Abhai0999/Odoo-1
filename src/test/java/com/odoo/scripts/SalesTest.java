package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.features.SalesFeature;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest{
	String[] cust_data;
	SalesFeature cusf;
	@Test(priority=1)
	public void createCustomer(){
		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		 cust_data= eu.readData("Sheet1", "create customer_2");
		lf.login(cust_data[1], cust_data[2]);
		
		/*cf.clickCRMf();
		cf.salesDiv();
		cf.customer();
		*/
		cusf=new SalesFeature(driver);
		cusf.createCust(cust_data);
		
		//cf.salesDiv();
		//cf.customer();
		cusf.verifyCreateCustomer(cust_data[3]);
		cf.logout();
					
		
	}
	
	/*@Test
	public void deleteCustomer1(){
		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] cust_data = eu.readData("Sheet1", "create customer_2");
		lf.login(cust_data[1], cust_data[2]);
		
		cs.clickCRMf();
		cf.salesDiv();
		cf.customer();

		
		SalesFeature cusf=new SalesFeature(driver);
		cusf.cust_del_F(cust_data);
	}*/
	/*@Test
	public void deleteCustomer2() {
		cusf.cust_del_F2();
	}*/
	@Test(priority=2)
	public void createCustImport() {
		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		 cust_data= eu.readData("Sheet1", "create customer_2");
		lf.login(cust_data[1], cust_data[2]);
		SalesFeature cusf=new SalesFeature(driver);
		cusf.createCustIMP_f();
		
	}
	

}
