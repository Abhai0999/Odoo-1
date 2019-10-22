package com.odoo.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.LostreasonSteps;
import com.odoo.steps.SalesTeamSteps;

public class Configurationfeatures 
{
  LostreasonSteps lrs;
  CommonSteps cs;
  SeleniumLib sl;
  SalesTeamSteps stp;
  public Configurationfeatures(WebDriver driver)
  {
	  lrs=new LostreasonSteps(driver);
	  cs=new CommonSteps(driver);
	  sl=new SeleniumLib(driver);
	  stp=new SalesTeamSteps(driver);
			  
  }
  public void customerislost()
  {
	  sl.iSleep(7);
	  cs.clickCrm();
	  sl.iSleep(5);
	  cs.clickonconfiguration();
	  sl.iSleep(5);
	  lrs.lostrasoncust();
		
  }
  public void salesteamcraeated(String[] teamData) throws EncryptedDocumentException, IOException  
  {
	  sl.iSleep(7);
	  cs.clickCrm();
	  sl.iSleep(5);
	  cs.clickonconfiguration();
	  sl.iSleep(7);
	  cs.clicksalesteamoption();
	  sl.iSleep(7);
	  stp.clickonsalescrate();
	 
      sl.iSleep(7);
	  stp.salesteam(teamData);
	  
	  sl.iSleep(7);
	  stp.salesteamrandom();
	  
  }
}
