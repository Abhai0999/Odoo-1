package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;

public class ConfigurationFeatures 
{
	CommonSteps cms;
	SalesTeamSteps sts; 
	
	public ConfigurationFeatures(WebDriver driver) 
	{
		cms=new CommonSteps(driver);
		sts=new SalesTeamSteps(driver);
	}
	
	public void createSalesTeam(String[] salesteamData) 
	{
		
		cms.clickCRM();
		cms.clickConfiguration();
		cms.clickSaleTeam();
		sts.clickCreate();
		sts.createSalesTeam(salesteamData);
		sts.verifyCrtSalesTeam(salesteamData);
	}
	public void deleteSalesTeam(String[] salesTeamData) 
	{
		cms.clickCRM();
		cms.clickConfiguration();
		cms.clickSaleTeam();
		sts.deleteSalesTeam(salesTeamData);
		sts.verifyDltSalesTeam(salesTeamData);
	}
}
