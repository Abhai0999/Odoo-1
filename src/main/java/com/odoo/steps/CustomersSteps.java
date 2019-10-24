package com.odoo.steps;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomersPage;

public class CustomersSteps 
{
    WebDriver driver;
    BasePage bp;
    SeleniumLib sl;
    CustomersPage cp;
    Random rm;
    
	
	
	public CustomersSteps(WebDriver driver)
	
	{
		this.driver=driver;
		bp = new BasePage();
		cp = new CustomersPage();
		sl = new SeleniumLib(driver);
	
	}
	

	public void clickCreate()
	
	{
		
		sl.iSleep(7);
		driver.findElement(By.xpath(cp.create)).click();
	}
	
	public void createCustomer(String[] customerData)                        
	
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(cp.customerName)).sendKeys(sl.randomValues(customerData[3]+"-"+"{0}"));
		driver.findElement(By.xpath(cp.street)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.city)).sendKeys(customerData[5]);
		WebElement state = driver.findElement(By.xpath(cp.state));
		state.sendKeys(customerData[6]);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.zip)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(cp.country)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.mobileNumber)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(cp.email)).sendKeys(customerData[10]);
		sl.iSleep(10);
		driver.findElement(By.xpath(cp.upload)).click();        
		
		try 
		{                       
			
			Runtime.getRuntime().exec("D:\\SeleniumAutomation\\Odoo\\resources\\upload.exe");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		sl.iSleep(10);
		driver.findElement(By.xpath(cp.save)).click();
		sl.iSleep(10);
	}
	
}	
