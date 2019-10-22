package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.PipelineSteps;

public class PipeLineFeatures 
{
	WebDriver driver;
   PipelineSteps ps;
   CommonSteps cs;
   SeleniumLib sl;
   LoginFeatures lf;
  public PipeLineFeatures(WebDriver driver)
  {
	  ps=new PipelineSteps(driver);
	  cs=new CommonSteps(driver);
	  sl=new SeleniumLib(driver);
	  lf=new LoginFeatures(driver);
  }
  public void createpipeline(String[] dataPipeline)
  {
	  sl.iSleep(7);
	  cs.clickCrm();
		
	  sl.iSleep(7);
	  cs.clickonSales();
	  sl.iSleep(6);
	  ps.clickpipeline();
	  sl.iSleep(6);
	  ps.createpipeline(dataPipeline);
	  sl.iSleep(5);

	   ps.clickf();
	   sl.iSleep(6);
	  
	   ps.clickonadd();
	   sl.iSleep(5);
  }
}
