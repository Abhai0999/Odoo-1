package com.odoo.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.SalesTeamPage;

public class SalesTeamSteps 

{
	WebDriver driver;
    BasePage bp;
    SeleniumLib sl;
    SalesTeamPage stp;
    CommonSteps cs;
    
	
	
	public SalesTeamSteps(WebDriver driver)                                
	
	{
		this.driver=driver;
		bp = new BasePage();
		stp = new SalesTeamPage();
		sl = new SeleniumLib(driver);
		cs = new CommonSteps(driver);
	
	}
	
	public void createSales()
	{
		
		driver.findElement(By.xpath(stp.createSales)).click();
		
	}
	
	public void salesTeam(String[] salesteamdata)
	
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.SalesTeamName)).sendKeys(salesteamdata[1]);
		sl.iSleep(4);
		WebElement tmLead = driver.findElement(By.xpath(stp.teamLeaderName));
		tmLead.sendKeys(salesteamdata[2]);
		sl.iSleep(4);
		tmLead.sendKeys(Keys.ARROW_DOWN);
		tmLead.sendKeys(Keys.ENTER);
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.tlemail)).sendKeys(salesteamdata[3]);
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.tlsave)).click();
		sl.iSleep(9);
		driver.findElement(By.xpath(stp.aliasemail)).sendKeys(salesteamdata[4]);
		sl.iSleep(6);
        driver.findElement(By.xpath(stp.addTeam)).click();
        sl.iSleep(4);
		driver.findElement(By.xpath(stp.createtm)).click();
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.tmname)).sendKeys(salesteamdata[5]);
		driver.findElement(By.xpath(stp.tmemail)).sendKeys(salesteamdata[6]);
        driver.findElement(By.xpath(stp.tmmobile)).sendKeys(salesteamdata[7]);
        sl.iSleep(6);
        driver.findElement(By.xpath(stp.savclos)).click();
        sl.iSleep(9);
        driver.findElement(By.xpath(stp.salesteamSave)).click();
		
		
	}
}
