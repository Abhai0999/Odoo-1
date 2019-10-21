package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;

public class ConfigurationFeatures
{
	CommonSteps cs;
	SalesTeamSteps sts;
	
	public ConfigurationFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
		sts=new SalesTeamSteps(driver);
	}
	
	public void createSalesTeam(String salesnmae,String [] salesData)
	{
		cs.clickOnCRM();
		cs.clickOnConfiguration();
		cs.clickOnSalesTeam();
		cs.clickOnCreate();
		sts.createSalesTeam(salesnmae, salesData);
		cs.clickOnSave();
	}
	
	
	
	
}
