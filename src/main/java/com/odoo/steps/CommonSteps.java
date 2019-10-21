package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomersPage;


public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	CustomersPage cp;
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
		
	}
	
	public void clickMenuDrpDwnList()
	
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	
	{
		
		driver.findElement(By.xpath(bp.logout)).click();
	}

	public void clickCrm() {
		sl.iSleep(4);
		driver.findElement(By.xpath(bp.Crm)).click();
		
		
		
	}
	public void clickSales() {
		sl.iSleep(4);
		driver.findElement(By.xpath(bp.Sales)).click();
		
	}
	public void clickCust() {
		sl.iSleep(4);
		driver.findElement(By.xpath(bp.Customer)).click();
		
		
	}
	
}
