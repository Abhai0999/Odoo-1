package com.odoo.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.MyPipelinePage;

import lombok.extern.java.Log;

public class MyPipelineSteps
{

	
		
		WebDriver driver;
		
		BasePage bp;
		SeleniumLib sl;
		MyPipelinePage mpp;
		
		
		public MyPipelineSteps(WebDriver driver)
		{
			
			this.driver=driver;
		   
			bp=new BasePage();
			sl=new SeleniumLib(driver);
			mpp=new MyPipelinePage();
		}
		
		public void createPipeline(String Opportunity)
		
		{
			
			sl.iSleep(6);
			driver.findElement(By.xpath(mpp.createBtn)).click();
			sl.iSleep(3);
			driver.findElement(By.xpath(mpp.oppoinput)).sendKeys(Opportunity);
			
			WebElement custSel = driver.findElement(By.xpath(mpp.customerselBtn));
			custSel.sendKeys("Abdul");
			//custSel.sendKeys(Keys.ARROW_DOWN);
		     custSel.sendKeys(Keys.ENTER);
			sl.iSleep(6);
			WebElement rev = driver.findElement(By.xpath(mpp.expectedrevn));
			rev.click();
			rev.sendKeys(Keys.CONTROL+"a");
			rev.sendKeys("90000");
			sl.iSleep(2);
			driver.findElement(By.xpath(mpp.addBtn)).click();	
		}
		
		public void verifyOpportunity()
		{
			try
			{	
		    String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
			FileInputStream fist=new FileInputStream(new File(filepath));
			Workbook wbe = WorkbookFactory.create(fist);
			Cell cl1 = wbe.getSheet("verifysheet").getRow(3).getCell(1);
			sl.iSleep(2);
			String namec = cl1.getStringCellValue();
			String verText = driver.findElement(By.xpath("//div[@role='article']//span[text()='"+namec+"']")).getText();
		
	       Assert.assertEquals(verText,namec);
	       System.out.println("opportunity is verified");
	       
			
			}
	   	catch (EncryptedDocumentException e) 
		{
			
		}
			catch (IOException e) 
			{
				
			}
			
			
		}

}
