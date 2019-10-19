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
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
	public void clickOnCrm()
	{
	    sl.iSleep(5);
		driver.findElement(By.xpath(bp.Crm)).click();
	}
	
	public void clickOnSales()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.salesButton)).click();
	}
	
	public void clickOnCustomer()
	{
		sl.iSleep(5);
		 driver.findElement(By.xpath(bp.clickCustmer)).click();
	}
	
}
