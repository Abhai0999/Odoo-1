package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest 
{
//	@Test()
//	public void createSalesMeetTeam()
//	{
//		String filepath = GenericLib.dir+"/testdata/Odoodata1.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		eu.readAndWriteData("Sheet1", 3, 3);
//		eu.readAndWriteData("Sheet1", 3, 4);
//		//eu.readAndWriteData("Sheet1", 3, 5);
//		
//		
////		eu.readAndWriteData("Sheet1", "createSalesMeet_ID", 6);
//
//		String[] salesTeam = eu.readData("Sheet1", "createSalesMeet_ID");
//
//
//		lf.login(salesTeam[1], salesTeam[2]);
//		cnfgFe.createSalesTeam(salesTeam);
//		
//		cnfgFe.verifySalesTeam(salesTeam[3], salesTeam[3]);
//
//	}
	
//	@Test()
//	public void createSalesSmsTeam()
//	{
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		eu.readAndWriteData("Sheet1", "createSalesSms_ID", 6);
//		String[] salesTeam = eu.readData("Sheet1", "createSalesSms_ID");
//		lf.login(salesTeam[1], salesTeam[2]);
//		cnfgFe.createSalesTeam(salesTeam);
//		cnfgFe.verifySalesTeam(salesTeam[3], salesTeam[3]);
//
//	}
//	
//	@Test()
//	public void createSalesCallTeam()
//	{
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		
//		
//		
//		eu.readAndWriteData("Sheet1", "createSalesCall_ID", 6);
//		String[] salesTeam = eu.readData("Sheet1", "createSalesCall_ID");
//		lf.login(salesTeam[1], salesTeam[2]);
//		cnfgFe.createSalesTeam(salesTeam);
//		cnfgFe.verifySalesTeam(salesTeam[3], salesTeam[3]);
//
//	}
//	
//	@Test()
//	public void createSalesEamilTeam()
//	{
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		eu.readAndWriteData("Sheet1", "createSalesEmail_ID", 6);
//	String[] salesTeam = eu.readData("Sheet1", "createSalesEmail_ID");
//	lf.login(salesTeam[1], salesTeam[2]);
//		cnfgFe.createSalesTeam(salesTeam);
//		cnfgFe.verifySalesTeam(salesTeam[3], salesTeam[3]);
//
//	}
	
	
//	@Test(dependsOnMethods= {"createSalesMeetTeam"})
//	public void dltSalesMeetTeam()
//	{
//		
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] dltSalesTeam = eu.readData("Sheet1", "createSalesMeet_ID");
//		lf.login(dltSalesTeam[1], dltSalesTeam[2]);
//		cnfgFe.dltSalesTeam(dltSalesTeam);
//		cnfgFe.verifyDltSalesTeam(dltSalesTeam[3]);
//		
//	}
//	@Test(dependsOnMethods= {"createSalesSmsTeam"})
//	public void dltSalesSmsTeam()
//	{
//		
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] dltSalesTeam = eu.readData("Sheet1", "createSalesSms_ID");
//		lf.login(dltSalesTeam[1], dltSalesTeam[2]);
//		cnfgFe.dltSalesTeam(dltSalesTeam);
//		cnfgFe.verifyDltSalesTeam(dltSalesTeam[3]);
//		
//	}
//	@Test(dependsOnMethods= {"createSalesCallTeam"})
//	public void dltSalesCallTeam()
//	{
//		
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] dltSalesTeam = eu.readData("Sheet1", "createSalesCall_ID");
//		lf.login(dltSalesTeam[1], dltSalesTeam[2]);
//		cnfgFe.dltSalesTeam(dltSalesTeam);
//		cnfgFe.verifyDltSalesTeam(dltSalesTeam[3]);
//		
//	}
//	@Test(dependsOnMethods= {"createSalesEamilTeam"})
//	public void dltSalesEamilTeam()
//	{
//		
//		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
//		ExcelUtilities eu=new ExcelUtilities(filepath);
//		String[] dltSalesTeam = eu.readData("Sheet1", "createSalesEmail_ID");
//		lf.login(dltSalesTeam[1], dltSalesTeam[2]);
//		cnfgFe.dltSalesTeam(dltSalesTeam);
//		cnfgFe.verifyDltSalesTeam(dltSalesTeam[3]);
//		
//	}
//	

	@Test
	public void createLostReason()
	{
		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("sheet1", "createLostReason_ID");
		lf.login(data[1], data[2]);
		cnfgFe.createLostReason(data);
		cnfgFe.verifyCreateLostReason(data, data);
		

	}
}
