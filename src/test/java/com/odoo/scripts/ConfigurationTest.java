package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest
{ 
	@Test
	public void createSalesTeam() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_salesTeam_ID",4);
		
		String[] salesTeamData = eu.readData("Sheet1","create_salesTeam_ID");
		lf.login(salesTeamData[1],salesTeamData[2]);
		
		cff.createSalesTeam(salesTeamData);
	}
	@Test(dependsOnMethods= {"createSalesTeam"})
	public void deleteSalesTeam() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] salesTeamData = eu.readData("Sheet1", "create_salesTeam_ID");
		
		lf.login(salesTeamData[1],salesTeamData[2]);
		cff.deleteSalesTeam(salesTeamData);	
	}
}
