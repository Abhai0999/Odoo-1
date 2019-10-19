package com.odoo.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.ExcelUtilities;
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
	
	public void delCustomer(String delCustmername) 
	{
    
		sl.iSleep(5);
		driver.findElement(By.xpath("//div[contains(@class,'oe_kanban_global_click')]//span[text()='"+delCustmername+"']")).click();
		sl.iSleep(3);
		WebElement act = driver.findElement(By.xpath(cp.action));
		act.click();
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.delBtn)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(cp.okBtn)).click();
       }  
	}
	
	
	

