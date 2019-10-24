package com.odoo.steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomersPage;
import com.odoo.pageobjects.PipelinePage;

public class PipelineSteps 

{
	WebDriver driver;
    BasePage bp;
    SeleniumLib sl;
    CustomersPage cp;
    Random rm;
    PipelinePage pp;
    
	
	
	public PipelineSteps(WebDriver driver)
	
	{
		this.driver=driver;
		bp = new BasePage();
		cp = new CustomersPage();
		sl = new SeleniumLib(driver);
		pp = new PipelinePage();
	
	}
	
    public void clickCreatePipeline()
	
	{
		
		sl.iSleep(7);
		driver.findElement(By.xpath(pp.pipelinecreate)).click();
	}
	
	public void createNewOpportunity(String[] entryData)
	
	{
		sl.iSleep(7);
		driver.findElement(By.xpath(pp.customerTxtFld)).sendKeys(entryData[3]);
		WebElement customer = driver.findElement(By.xpath(pp.customerTxtFld));
		customer.sendKeys(entryData[4]);
		customer.sendKeys(Keys.ARROW_DOWN);
		customer.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(pp.addButton)).click();
		
	
	}
	
}
