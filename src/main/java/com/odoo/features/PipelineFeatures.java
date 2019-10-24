package com.odoo.features;

import org.openqa.selenium.WebDriver;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.PipelinePage;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.PipelineSteps;

public class PipelineFeatures 

{
      PipelinePage pp;
      PipelineSteps ps;
      SeleniumLib sl;
      CommonSteps cs;
      
      
      public PipelineFeatures(WebDriver driver)
      
      {
    	  ps = new PipelineSteps(driver);
    	  sl = new SeleniumLib(driver);
    	    
      }
      
      public void createNewOpportunity(String[] entryData)
      
      {
    	  cs.clickCRM();
    	  cs.clickSales();
  	      ps.clickCreatePipeline();
  	      ps.createNewOpportunity(entryData);
      }
}      