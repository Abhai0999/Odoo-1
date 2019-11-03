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

		@Test(enabled=false)
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

		@Test(dependsOnMethods= {"newCustomer"})
		public void createOpportunity()
		{
			String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
			ExcelUtilities eu=new ExcelUtilities(filepath);
			eu.readAndWriteData("Sheet1", 7, 3);
			String[] data = eu.readData("Sheet1", "createOpportunity_ID");
			lf.login(data[1], data[2]);
			String[] data1 = eu.readData("Sheet1", "createCustomer_ID");
			
			sf.createOpportunity(data, data1);
			sf.verifyOpportunity(data);
		}

		@Test(enabled=false)
		public void deleteOpportunity()
		{
			String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
			ExcelUtilities eu=new ExcelUtilities(filepath);
			String[] data = eu.readData("Sheet1", "createOpportunity_ID");
			lf.login(data[1], data[2]);
			sf.deleteOpportunity(data);
			sf.verifyDltOpportunity(data);
		} 

	@Test(dependsOnMethods= {"createOpportunity","newCustomer"})
	public void scheduledActivity()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "scheduledMeetingActivity_ID");
		lf.login(data[1], data[2]);
		sf.schdMeetingAct(data);
		String[] data1 = eu.readData("Sheet1", "createOpportunity_ID");
		sf.verfschdMeetingAct(data, data1);
		sf.MeetingActivityDone(data);
		sf.verifyMeetingActDone(data);		
		sf.dragOpportunityNewToQualified(data1);
		sf.verifyDragOpportunityToQlfd(data1);
	}
	
	@Test(dependsOnMethods= {"scheduledActivity","createOpportunity","newCustomer"})
	public void creatSalesAct()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "scheduledCallActivity_ID");
		lf.login(data[1], data[2]);
		sf.creatCallAct(data);
		String[] data1 = eu.readData("Sheet1", "createOpportunity_ID");
		sf.verifyCreatCallAct(data1, data);
		
	}


}
