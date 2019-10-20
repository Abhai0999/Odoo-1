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
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.logout)).click();
	}
    	
	 public void CrmBtn()
	 {
		 sl.iSleep(15);
		driver.findElement(By.xpath(bp.Crm)).click();
		
			}
	 
	  public void ClickSales()
	  {
		    sl.iSleep(10);
	  driver.findElement(By.xpath(bp.sales)).click();
				
		 }

	 public void SelectCustomer()
	 {
		
	sl.iSleep(4);
	driver.findElement(By.xpath(bp.selectCustomers)).click();
				
		 }
	
}
