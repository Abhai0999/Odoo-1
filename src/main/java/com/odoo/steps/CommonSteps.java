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
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.logout)).click();
	}
	public void clickOnCRM()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.Crm)).click();	
	}
	public void clickOnSales()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.sales)).click();
	}
	public void clickOncustomers()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.customers)).click();
	}

	
	
}
