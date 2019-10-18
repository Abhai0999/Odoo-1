package com.odoo.scripts;

import java.util.Random;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class CreateCustomerTest extends BaseAbstractTest {

	@Test

	public void createCustomer() {
		String name;
		Random rm = new Random();
		int randonvalue = rm.nextInt(1000);
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "CreateCustomer_ID");
		
		name = customerData[3].concat(Integer.toString(randonvalue));
		eu.setCellValue("Sheet1", 2, 2, name);
		lf.login(customerData[1], customerData[2]);

		sf.createNewCustomer(customerData);
		

	}
//	@Test (priority=2)
//	public void deleteCustomer() {
//		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//		ExcelUtilities eu = new ExcelUtilities(filepath);
//		String[] Data= eu.readData("Sheet1", "DeleteCustomer_ID");
//		lf.login(Data[1], Data[2]);
//		sf.deleteCustomer(Data[3]);
//	}

}
