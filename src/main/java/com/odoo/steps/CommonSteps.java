package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	
	public CommonSteps(WebDriver driver)
	{	this.driver=driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	public void clickMenuDrpDwnList()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
	public void clickSales()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.Sales)).click();
	}
	
	public void clickCRM()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.Crm)).click();
	}
	
	
	public void clickCst()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.Customer)).click();
	}
	public void clickConfiguration()
	{
		sl.iSleep(20);
		driver.findElement(By.xpath(bp.configuration)).click();
	}
	public void clickSalesTeam()
	{
		sl.iSleep(20);
		driver.findElement(By.xpath(bp.salesTeamBtn)).click();
	}
	
	public void clickMyPipeline()
	{
		sl.iSleep(20);
		driver.findElement(By.xpath(bp.MyPipleline)).click();
	}
	
	
}