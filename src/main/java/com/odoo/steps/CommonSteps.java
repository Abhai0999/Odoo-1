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

	public void clickCRM() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.crm)).click();
	}
	public void clickSales() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.salesTab)).click();
	}
	public void clickCustomers() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.customersTab)).click();
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
}