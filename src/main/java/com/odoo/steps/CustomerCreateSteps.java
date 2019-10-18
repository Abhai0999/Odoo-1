package com.odoo.steps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class CustomerCreateSteps 
{
	WebDriver driver;
	CustomerPage cp;
    BasePage bp;
    SeleniumLib sl;
    
   public CustomerCreateSteps(WebDriver driver)
   {
	   this.driver=driver;
	   cp=new CustomerPage();

	   sl=new SeleniumLib(driver);
	   
   }
  public void clickCreateBtn() 
  {
	  driver.findElement(By.xpath(cp.createBtn)).click();
	  
  }
   public void createCustomer(String[] customerData)
  {
	  driver.findElement(By.xpath(cp.nameBx)).sendKeys(customerData [3]+sl.randomvalue()); 
	  driver.findElement(By.xpath(cp.streetBx1)).sendKeys(customerData [4]); 
	  driver.findElement(By.xpath(cp.streetBx2)).sendKeys(customerData [5]); 
	  driver.findElement(By.xpath(cp.city)).sendKeys(customerData [6]); 
	  WebElement state = driver.findElement(By.xpath(cp.stateBx)); 
	  state.sendKeys(customerData [7]);
	  state.sendKeys(Keys.ARROW_DOWN);
	  state.sendKeys(Keys.ENTER);
	  driver.findElement(By.xpath(cp.phone)).sendKeys(customerData [8]);
	  driver.findElement(By.xpath(cp.emailBx)).sendKeys(customerData [9]); 
	  sl.iSleep(3);
	  driver.findElement(By.xpath(cp.editbtn)).click();
	  sl.iSleep(7);
	  try
	  {
		  Runtime.getRuntime().exec("C:\\seleniumlive\\Odoo\\resources\\upload.exe");
	  }
	  catch(IOException e) 
	  {
		  e.printStackTrace();
	  }
	  sl.iSleep(5);
	  driver.findElement(By.xpath(cp.saveBtn)).click();
}
   
   public void verifyCreateCustomer() throws EncryptedDocumentException, IOException 
	{
		sl.iSleep(4);
       String verifycstmer = driver.findElement(By.xpath(cp.custverf)).getText();	
       
   ExcelUtilities es=new ExcelUtilities();
     sl.iSleep(5);
     String namec = es.verifyCustdata(verifycstmer);
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
		
		
		
		
	
}}

