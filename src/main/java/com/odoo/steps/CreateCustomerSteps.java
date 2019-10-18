package com.odoo.steps;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.odoo.generic.ExcelUtilities;
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
	
	public void verifyCreateCustomer() throws EncryptedDocumentException, IOException 
	{
		sl.iSleep(4);
        String verifycstmer = driver.findElement(By.xpath(cp.verCus)).getText();	
        
    ExcelUtilities es=new ExcelUtilities();
      sl.iSleep(5);
      String namec = es.writeVrfyDat(verifycstmer);
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

}

