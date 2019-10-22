package com.odoo.scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest 
{
@Test
public void lost()
{
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData =eu.readData("Sheet1", "createCustomer_ID");
	lf.login(customerData[1], customerData[2]);
    cfs.customerislost();
}
@Test
public void salesteam() throws EncryptedDocumentException, IOException 
{
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData =eu.readData("Sheet1", "createCustomer_ID");
	lf.login(customerData[1], customerData[2]);	
	
    String[] teamData = eu.readData("Sheet1", "salesteam_ID");
    cfs.salesteamcraeated(teamData);
         
         

}}




