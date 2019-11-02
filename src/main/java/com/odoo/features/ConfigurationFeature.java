package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;

public class ConfigurationFeature 
{
	SalesTeamSteps sts;
	CommonSteps cs;
	SeleniumLib sl;
	
	public ConfigurationFeature(WebDriver driver)
	{
		sts=new SalesTeamSteps(driver); 
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
		
	}
	
	public void createSalesTeam(String[] salesTeam )
	{
		cs.clickCRM();
		sl.iSleep(5);
		cs.clickConfiguration();
		cs.clickSalesTeam();
		sl.iSleep(5);
		sts.createSalesTeam(salesTeam);
		
	}
	
	public void verifySalesTeam(String expText,String teamName )
	{
		sts.verifySalesTeam(expText, teamName);
	}
	
	public void dltSalesTeam(String[] salesTeamName)
	{
		cs.clickCRM();
		sl.iSleep(5);
		cs.clickConfiguration();
		cs.clickSalesTeam();
		sl.iSleep(5);
		sts.dltSalesTeam(salesTeamName);
	}
		
		
	
	public void verifyDltSalesTeam(String expSalesTeam )
	{
			sts.verifyDltSalesTeam(expSalesTeam);
	}
	

}