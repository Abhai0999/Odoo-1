package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.PipelinePage;

public class PipelineSteps 
{
 WebDriver driver;
 PipelinePage pp;
 BasePage bp;
 SeleniumLib sl;
	public PipelineSteps(WebDriver driver)
	{
		this.driver=driver;
		pp=new PipelinePage();
	    bp=new BasePage();
	    sl=new SeleniumLib(driver);
		
	}
	
	public void clickpipeline()
	{
		driver.findElement(By.xpath(pp.clickpipelinecrate)).click();
	}
	public void createpipeline(String[] dataPipeline)
	{   sl.iSleep(5);
		driver.findElement(By.xpath(pp.opportiniuty)).sendKeys(dataPipeline[1]);
		driver.findElement(By.xpath(pp.oppcustomer)).sendKeys(dataPipeline[2]);
		driver.findElement(By.xpath(pp.revenue)).sendKeys(dataPipeline[3]);
		
	}
	public void clickonadd()
	{
		driver.findElement(By.xpath(pp.oppadd)).click();
	}
	public void clickf() 
	{
		driver.findElement(By.xpath(pp.finalclick)).click();
	}
}



