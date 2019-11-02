package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.MyPipeline;

public class MyPipelineSteps
{
	WebDriver driver;
	MyPipeline mp;
	SeleniumLib sl;
	
	public MyPipelineSteps(WebDriver driver)
	{
		 this.driver=driver;
	     mp = new MyPipeline();
	     sl = new SeleniumLib(driver);
	}
	
	public void createPipeline(String[] pipeline)
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(mp.createPipeline)).click();
		
		sl.iSleep(5);
		driver.findElement(By.xpath(mp.createOpportunity)).sendKeys(pipeline[3]);
		
		WebElement cx=driver.findElement(By.xpath(mp.customer));
		cx.click();
		sl.iSleep(5);
		cx.sendKeys(sl.randomNumber(pipeline[4]));
		
       driver.findElement(By.xpath(mp.ExpectedReve)).sendKeys(pipeline[5]);
       sl.iSleep(5);
       driver.findElement(By.xpath(mp.Add)).click();
		
		
		
		
	}
	

}
