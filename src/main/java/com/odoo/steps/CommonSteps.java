package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;

public class CommonSteps 
{
	WebDriver driver;
	SeleniumLib sl;
	BasePage bp;
	
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	public void clickMenuDrpDwnList()
	{
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
	public void clickSales()
	{
		sl.iSleep(3);
		driver.findElement(By.xpath(bp.sales)).click();
	}
	
	public void clickCustomers()
	{
		sl.iSleep(3);
		driver.findElement(By.xpath(bp.customers)).click();
	}
	
	public void clickCRM()
	{
		sl.iSleep(3);
		driver.findElement(By.xpath(bp.Crm)).click();
	}
	
	
	
	
	
}
