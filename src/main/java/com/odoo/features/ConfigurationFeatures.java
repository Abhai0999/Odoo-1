package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;
import com.odoo.steps.SettingSteps;

public class ConfigurationFeatures 
{
	CommonSteps cms;
	SalesTeamSteps sts;
	SettingSteps ss;
	
	public ConfigurationFeatures(WebDriver driver) 
	{
		cms=new CommonSteps(driver);
		ss= new SettingSteps(driver);
		sts=new SalesTeamSteps(driver);
	}
	
	public void createUser(String[] userData) 
	{
		cms.clickCRM();
		cms.clickConfiguration();
		cms.clickSetting();
		ss.clickMngUser();
		ss.createUser(userData);
	}
	
	public void createSalesTeam(String[] salesteamData) 
	{
		cms.clickCRM();
		cms.clickConfiguration();
		cms.clickSaleTeam();
		sts.createSalesTeam(salesteamData);
		//sts.verifyCrtSalesTeam(salesteamData);
	}
	public void deleteSalesTeam(String[] salesTeamData) 
	{
		cms.clickCRM();
		cms.clickConfiguration();
		cms.clickSaleTeam();
		sts.deleteSalesTeam(salesTeamData);
		//sts.verifyDltSalesTeam(salesTeamData);
	}
}
