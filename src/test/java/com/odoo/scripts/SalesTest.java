package com.odoo.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest
{
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData =eu.readData("Sheet1", "createCustomer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.createCustomer(customerData);

		
	}
 @Test
 public void deletecustomerfrompage()
 {
	 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		
		lf.login(customerData[1], customerData[2]);
		String[] sel = eu.readData("Sheet1","customersel_ID");
		sf.delcustmoer(sel[1]);
 }
 @Test
 public void custimp()
 {
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData = eu.readData("Sheet1", "createCustomer_ID");
		
	lf.login(customerData[1], customerData[2]);
	sf.customerimport();
 }
}
