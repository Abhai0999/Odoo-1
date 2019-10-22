package com.odoo.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.SalesTeamPage;

public class SalesTeamSteps 
{

	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	SalesTeamPage stp;
	
	public SalesTeamSteps(WebDriver driver)
	{
		
		this.driver=driver;
	    stp=new SalesTeamPage();
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	public void salesTeamCreate(String[] salestmnm)
	{
		ExcelUtilities ex=new ExcelUtilities();
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.create)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.salestmName)).sendKeys(salestmnm[1]+sl.randomValue());
		WebElement teamldrName = driver.findElement(By.xpath(stp.teamLeaderNm));
		teamldrName.sendKeys(salestmnm[2]);
		sl.iSleep(3);
		teamldrName.sendKeys(Keys.ARROW_DOWN);
		teamldrName.sendKeys(Keys.ENTER);
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.tlemail)).sendKeys(salestmnm[3]);
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.tlsave)).click();
		
		
		ex.readAndWriteData("verifysheet", 4, 2, 3);
		sl.iSleep(9);
		driver.findElement(By.xpath(stp.teamAlias)).sendKeys(salestmnm[4]);
		
		WebElement assign = driver.findElement(By.xpath(stp.assignt));
		assign.sendKeys(salestmnm[5]);
		sl.iSleep(4);
		assign.sendKeys(Keys.ENTER);
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.addtm)).click();
		sl.iSleep(4);
		driver.findElement(By.xpath(stp.createtm)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.tmname)).sendKeys(salestmnm[6]);
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.tmemail)).sendKeys(salestmnm[7]);
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.tmmobile)).sendKeys(salestmnm[8]);
		sl.iSleep(3);
		driver.findElement(By.xpath(stp.savclos)).click();
		ex.readAndWriteData("verifysheet", 4, 6, 7);
		sl.iSleep(11);
		driver.findElement(By.xpath(stp.salesteamSave)).click();
		
	
		
		
  
	}	

	public void salesTeamVerify()
	{
		try
		{	
	    String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		FileInputStream fist=new FileInputStream(new File(filepath));
		Workbook wbe = WorkbookFactory.create(fist);
		Cell cl1 = wbe.getSheet("verifysheet").getRow(4).getCell(1);
		String namsal = cl1.getStringCellValue();
		
		sl.iSleep(4);
		String dltName = driver.findElement(By.xpath("//td[text()='"+namsal+"']")).getText();
   
       Assert.assertEquals(namsal, dltName);
       System.out.println("sales team  is verified");
		
		}
   	catch (EncryptedDocumentException e) 
	{
		
	}
		catch (IOException e) 
		{
			
		}
		
		
		
		
	}
	
}
