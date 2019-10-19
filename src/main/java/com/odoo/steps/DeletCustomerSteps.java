package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class DeletCustomerSteps 
{
	WebDriver driver;
	CustomerPage cp;
    BasePage bp;
    SeleniumLib sl;
    
   public DeletCustomerSteps(WebDriver driver)
   {
	   this.driver=driver;
	   cp=new CustomerPage();

	   sl=new SeleniumLib(driver);
	   
   }
   public void deleteCustomer(String deletCustmer) 
   {   
	    
	   sl.iSleep(5);
       driver.findElement(By.xpath("//div[contains(@class,'oe_kanban_global_click')]//span[text()='"+deletCustmer+"']")).click();
       sl.iSleep(5);
	   driver.findElement(By.xpath(cp.clickonaction)).click();
	   sl.iSleep(5);
	   driver.findElement(By.xpath(cp.clickondelete)).click();
	   sl.iSleep(7);
	   driver.findElement(By.xpath(cp.ok)).click();
	   
   }

}
