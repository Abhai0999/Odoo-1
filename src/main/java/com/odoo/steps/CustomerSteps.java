package com.odoo.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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
import com.odoo.pageobjects.CustomersPage;



public class CustomerSteps {
	WebDriver driver;
	SeleniumLib sl;
	CustomersPage cp;

public CustomerSteps(WebDriver driver){
	
	this.driver=driver;
    sl=new SeleniumLib(driver);
	cp=new CustomersPage();
	
}

public void clickCreate(){
	sl.iSleep(4);
	driver.findElement(By.xpath(cp.createCustomer)).click();	
	//sl.jsClick(driver.findElement(By.xpath(cp.createCustomer)));
}

public void createCustomer(String[] customerData){
	
	sl.iSleep(4);
	driver.findElement(By.xpath(cp.customerName)).sendKeys(customerData[3]+sl.randomValue()); 
	driver.findElement(By.xpath(cp.street1Address)).sendKeys(customerData[4]);
	driver.findElement(By.xpath(cp.cityName)).sendKeys(customerData[5]);
	WebElement state = driver.findElement(By.xpath(cp.stateName));
	state.sendKeys(customerData[6]);
	state.sendKeys(Keys.ARROW_DOWN);
	state.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath(cp.zipCode)).sendKeys(customerData[7]);
	driver.findElement(By.xpath(cp.countryName)).sendKeys(customerData[8]);
	driver.findElement(By.xpath(cp.phoneNumber)).sendKeys(customerData[9]);
	
	driver.findElement(By.xpath(cp.uploadPhoto)).click();
	sl.iSleep(4);
	
	try 
	{
		Runtime.getRuntime().exec("./Resource/upload.exe");
	} 
	catch (IOException e) 
	{	
		e.printStackTrace();
	}
	
	sl.iSleep(10);
	driver.findElement(By.xpath(cp.saveButton)).click();
	
}

     public void verifyCreateCustomer()  
	{
	
	try{
		sl.iSleep(10);
        String verifycstmer = driver.findElement(By.xpath(cp.VerCus)).getText();	
        
    ExcelUtilities es=new ExcelUtilities();
      sl.iSleep(5);
    String namec = es.verifyCreateCustomer(verifycstmer);
    
    
      System.out.println(namec);
      String[] namec1 = namec.split("-");
      String namec2 = namec1[1];
      String names = namec1[0];
      
       
       String title = driver.getTitle();
       String[] titl = title.split("-");
 	  String title1 = titl[0]+"-"+namec2;
 	  System.out.println(title1);
       Assert.assertEquals(title1,namec);
       System.out.println("customer is verified");
	
	}
	catch(EncryptedDocumentException e){
		
	
	}
	}

   public void deleteCustomer(String[]  name)
   {
  sl.iSleep(5);
  List<WebElement> AllcustomerName = driver.findElements(By.xpath(cp.existingCustomername));
   // ExcelUtilities es=new ExcelUtilities();
 
                  int count = AllcustomerName.size();
                  System.out.println("customer List:"+count);
                        for (int i = 0; i < count; i++) {
                     WebElement ele = AllcustomerName.get(i);
                     System.out.println(ele.getText()); 
                    
		
                    if(ele.getText().equalsIgnoreCase(name[3])){
                    	
                    	
               driver.findElement(By.xpath("//strong[contains(@class,'title')]/span[text()='" + name[3] + "']")).click();
                  //  	ele.click();
                    	
                    	break;
                    }
             }
  
    	 
       sl.iSleep(7);
      driver.findElement(By.xpath(cp.actionBtn)).click();
     driver.findElement(By.xpath(cp.deleteBtn)).click();
     sl.iSleep(8);
     driver.findElement(By.xpath(cp.okBtn)).click();
   
}

   public void importFile(){
	   
	   sl.iSleep(7);
	   driver.findElement(By.xpath(cp.importBtn)).click();
	   sl.iSleep(7);
	   driver.findElement(By.xpath(cp.loadFile)).click();
       sl.iSleep(10);
	   
	   try {
		Runtime.getRuntime().exec("./Resource/fileupload.exe");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	   sl.iSleep(10);
	   
	   driver.findElement(By.xpath(cp.impBtn)).click();
	   sl.iSleep(5);
	   
   }
   
   public void verifyImportFile(String sheet,int row,int cell){
	   
	  try{
		  sl.iSleep(5);
		   
		    String filepath=GenericLib.dir+ "./Resource/aa.xlsx";
		    FileInputStream fis= new FileInputStream(new File(filepath)) ; 
		    Workbook wb = WorkbookFactory.create(fis);
		           Cell cl1 = wb.getSheet(sheet).getRow(row).getCell(cell);
		           String actualName = cl1.getStringCellValue();
		           System.out.println("actual Name: "+actualName);
		   sl.iSleep(15);
	 String ExpctdName = driver.findElement(By.xpath("//div[contains(@class,'oe_kanban')]//span[text()='"+actualName+"']")).getText();
	
	//div[@class='oe_kanban_details']//span[text()='Kaniz']
	 
	
	 System.out.println("ExpectedCust Name:"+ExpctdName);
	   Assert.assertEquals(actualName, ExpctdName);
		   System.out.println("Import Is Verified");
	   }
	  catch(Exception e){
		  
	  }
		  }
	  }





















