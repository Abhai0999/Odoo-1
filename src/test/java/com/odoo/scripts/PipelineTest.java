package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class PipelineTest extends BaseAbstractTest
{
	@Test
	public void createopp()
	{
		
	
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData =eu.readData("Sheet1", "createCustomer_ID");
	lf.login(customerData[1], customerData[2]);
	
	String[] dataPipeline =eu.readData("Sheet1", "pipeline_ID");
	plf.createpipeline(dataPipeline);
	

	
	
    
		
	
}}
