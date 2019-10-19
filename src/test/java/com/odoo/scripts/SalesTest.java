package com.odoo.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
     {

//	@Test()
//	public void creteCustomeTest() 
//	{
//		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] customerData = eu.readData("verifysheet", "createCustomer_ID");
//		lf.login(customerData[1], customerData[2]);
//		
//			sf.createNewCustomer(customerData);
//		
//	}

//	@Test()
//	public void deleteTest()
//	{
//		
//		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] Data = eu.readData("verifysheet", "createCustomer_ID");
//		lf.login(Data[1],Data[2]);
//		sf.deleteCustmer(Data[3]);
//		
//		
//	}
	
	
	@Test
	public void importTest()
	{
		
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] Data = eu.readData("verifysheet", "createCustomer_ID");
		lf.login(Data[1],Data[2]);
		sf.importCusomerFeature();
		
	}
}
