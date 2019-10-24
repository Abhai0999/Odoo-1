package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest
{

	@Test
	public void salesTeamcreatedTest()
	{
	
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] data = eu.readData("Sheet1", "validLogin_ID");
	lf.login(data[1], data[2]);
	String[] data1 = eu.readData("Sheet1", "salesTeam_ID");
	stf.createSalesTeam(data1);
	
	}
}
