package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.LostreasonPage;

public class LostreasonSteps 
{
 WebDriver driver;
 LostreasonPage lrp;
 SeleniumLib sl;
  
 public LostreasonSteps(WebDriver driver)
 {
	 this.driver=driver;
	 lrp=new LostreasonPage();
	 sl=new SeleniumLib(driver);
 }
 public void lostrasoncust()
 {
	 driver.findElement(By.xpath(lrp.lostreason)).click();
	 sl.iSleep(5);
	 driver.findElement(By.xpath(lrp.createlost)).click();
	 sl.iSleep(5);
	 driver.findElement(By.xpath(lrp.lostname)).sendKeys("customer saying product is expensive");
	 sl.iSleep(5);
	 driver.findElement(By.xpath(lrp.lostsave)).click();
	 
 }
}
