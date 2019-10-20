package com.odoo.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest{
//	
//	@Test
//	public void createCustomer() {
//		
//			String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//			ExcelUtilities eu = new ExcelUtilities(filepath);
//			String[] customerData = eu.readData("Sheet1", "CreateCustomer_ID");
//			
//			
//			
//			lf.login(customerData[1], customerData[2]);
//			
//			sf.CreateNewCustomer(customerData);
//		
//  }
////
//	@Test
//	public void verfycreateCustomer(){
//		
//			String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//			ExcelUtilities eu = new ExcelUtilities(filepath);
//			String[] customerData = eu.readData("Sheet1", "VerifyCustomer_ID");
//			lf.login(customerData[1], customerData[2]);
//			//sf.VerifyCreateCustomer(customerData);
//			
//  }

//	@Test
//	public void deleteCustomer(){
//		
//			String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//			ExcelUtilities eu = new ExcelUtilities(filepath);
//			String[] customerData = eu.readData("Sheet1", "deleteCustomer_ID");
//			lf.login(customerData[1], customerData[2]);
//			String[] name = eu.readData("Sheet1", "deleteCustomer_ID");
//			
//			sf.DeleteExistingCustomer(name);
//			
//	}
	@Test
	public void IMportFile(){

		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "CreateCustomer_ID");
		lf.login(customerData[1], customerData[2]);
		
		String[] details = eu.readData("Sheet1", "CreateCustomer_ID");
	      //  sf.ImportFile();
	        sf.verifyImportedFile("Sheet1", 2, 2);
		
		
	}
	
	
}




