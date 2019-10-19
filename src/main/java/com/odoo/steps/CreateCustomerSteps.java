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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class CreateCustomerSteps
{
	
	WebDriver driver;
	CustomerPage cp;
	LoginSteps ls;
	BasePage bp;
	SeleniumLib sl;
	
	
	public CreateCustomerSteps(WebDriver driver)
	{
		
		this.driver=driver;
	    ls=new LoginSteps(driver);
	  
		cp=new CustomerPage();
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}

	public void clickCreate()
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.create)).click();
	}
	
	public void createCustmer(String[] customerData)
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.name)).sendKeys(customerData[3]+sl.randomValue());
		driver.findElement(By.xpath(cp.street)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.city)).sendKeys(customerData[5]);
		WebElement state = driver.findElement(By.xpath(cp.state));
		state.sendKeys(customerData[6]);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.phone)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(cp.email)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.editBtn)).click();
		sl.iSleep(3);

	try {
		Runtime.getRuntime().exec("E:\\seleniumadvancedec\\Odoo\\Resources\\upload.exe");
		
	}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		sl.iSleep(3);
	
	driver.findElement(By.xpath(cp.save)).click();
//		
//		try {
//			driver.findElement(By.xpath(cp.imok)).click();
//		} catch (Exception e) {
//			
//		}
	
	}
	
	public void verifyCreateCustomer() 
	{
		sl.iSleep(4);
        String verifycstmer = driver.findElement(By.xpath(cp.verCus)).getText();
        System.out.println(verifycstmer);
		try
		{	
	    String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		FileInputStream fist=new FileInputStream(new File(filepath));
		Workbook wbe = WorkbookFactory.create(fist);
		Cell cl1 = wbe.getSheet("verifysheet").getRow(1).getCell(3);
		sl.iSleep(2);
		
		cl1.setCellValue(verifycstmer);

		FileOutputStream fost=new FileOutputStream(new File(filepath));
	     wbe.write(fost);
	
		String namec = cl1.getStringCellValue();
		System.out.println(namec);
		
	
      String[] namec1 = namec.split("-");
      String namec2 = namec1[1];
     
       String title = driver.getTitle();
       String[] titl = title.split("-");
 	  String title1 = titl[0]+"-"+namec2;
 	  System.out.println(title1);
       Assert.assertEquals(title1,namec);
       System.out.println("customer is verified");
		
		}
   	catch (EncryptedDocumentException e) 
	{
		
	}
		catch (IOException e) 
		{
			
		}
		
	}
	
	public void importCustomerSteps()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.importBtn)).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(cp.loadFilBtn)).click();
		sl.iSleep(4);

		try {
			Runtime.getRuntime().exec("E:\\seleniumadvancedec\\Odoo\\Resources\\import.exe");
			
		}

			catch (Exception e)
			{
				e.printStackTrace();
			}
		
		sl.iSleep(4);
		
		driver.findElement(By.xpath(cp.rows)).click();
		WebElement sele = driver.findElement(By.xpath(cp.selNam));
		sele.sendKeys("Name");
		sele.sendKeys(Keys.ARROW_DOWN);
		sele.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath(cp.importBtn1)).click();
	}
	
	public void verifyImport()

	{
		
		try
		{	
			
	    String filepath=GenericLib.dir+"./Resources/Import.xlsx";
		FileInputStream fist=new FileInputStream(new File(filepath));
		Workbook wbe = WorkbookFactory.create(fist);
		Cell cl1 = wbe.getSheet("Sheet1").getRow(1).getCell(0);
		sl.iSleep(2);
		
		String name11 = cl1.getStringCellValue();
		System.out.println(name11);
		sl.iSleep(4);
		
		String verifycstmer = driver.findElement(By.xpath("//div[contains(@class,'oe_kanban_global_click')]//span[text()='"+name11+"']")).getText();
	       System.out.println(verifycstmer);
	       
           Assert.assertEquals(verifycstmer,name11);
       System.out.println(" import customer is verified");
		
		}
   	catch (EncryptedDocumentException e) 
	{
		
	}
		catch (IOException e) 
		{
			
		}
		
	}
	
}

