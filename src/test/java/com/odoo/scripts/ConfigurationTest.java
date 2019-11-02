
	
	package com.odoo.scripts;

	import org.testng.annotations.Test;

	import com.odoo.generic.ExcelUtilities;
	import com.odoo.generic.GenericLib;
	import com.odoo.webutils.BaseAbstractTest;

	public class ConfigurationTest extends BaseAbstractTest 
	{
		@Test()
		public void createSalesTeam()
		{
			{
				String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
				ExcelUtilities eu=new ExcelUtilities(filepath);
				eu.readAndWriteData("Sheet1", 3, 3);
				eu.readAndWriteData("Sheet1", 3, 4);
				eu.readAndWriteData("Sheet1", 3, 5);
				String[] salesTeam = eu.readData("Sheet1", "createSalesTeam_ID");
				lf.login(salesTeam[1], salesTeam[2]);
				cnfgFe.createSalesTeam(salesTeam);
				cnfgFe.verifySalesTeam(salesTeam[3], salesTeam[3]);

			}
		}
		
		@Test(dependsOnMethods= {"createSalesTeam"})
		public void dltSalesTeam()
		{
			String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
			ExcelUtilities eu=new ExcelUtilities(filepath);
			String[] dltSalesTeam = eu.readData("Sheet1", "createSalesTeam_ID");
			lf.login(dltSalesTeam[1], dltSalesTeam[2]);
			cnfgFe.dltSalesTeam(dltSalesTeam);
			cnfgFe.verifyDltSalesTeam(dltSalesTeam[3]);
		}

	}

