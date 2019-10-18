package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class DeleatCustomerSteps 

{
	WebDriver driver;
	CustomerPage cp;
	LoginSteps ls;
	BasePage bp;
	SeleniumLib sl;
	
	
	public DeleatCustomerSteps(WebDriver driver)
	{
		
		this.driver=driver;
	    ls=new LoginSteps(driver);
	  
		cp=new CustomerPage();
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	public void delCustomer()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.selectCust)).click();
		sl.iSleep(3);
		WebElement act = driver.findElement(By.xpath(cp.action));
		act.click();
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.delBtn)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(cp.okBtn)).click();
		
	}
	
	
}
