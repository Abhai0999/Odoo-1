package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.pageobjects.BasePage;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
	}
	public void clickCrm() 
	{
		driver.findElement(By.xpath(bp.Crm)).click();
		
	}
	public void clickonSales()
	{
		driver.findElement(By.xpath(bp.salesDrpDwn)).click();
	}
	public void clickonconfiguration()
	{
		driver.findElement(By.xpath(bp.configuration)).click();
	}
	public void clickonpipelinetab()
	{
		driver.findElement(By.xpath(bp.selectpipeline)).click();
	}
	public void clicksalesteamoption()
	{
		driver.findElement(By.xpath(bp.salesteamoption)).click();
	}
	public void clickMenuDrpDwnList()
	{
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
	
	public void ClickCustomerBtn()
	{
		driver.findElement(By.xpath(bp.customerselect)).click();
	}
}
