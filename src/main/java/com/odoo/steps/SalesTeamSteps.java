package com.odoo.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SalesTeamPage;

public class SalesTeamSteps 
{
 WebDriver driver;
 SalesTeamPage stp;
 CommonSteps cs;
 SeleniumLib sl;
 public SalesTeamSteps(WebDriver driver)
 {
	 this.driver=driver;
	 stp=new SalesTeamPage();
	 sl=new SeleniumLib(driver);
	 	 
 }
 public void clickonsalescrate()
 {
	 driver.findElement(By.xpath(stp.createsalesbutton)).click();
 }
 public void salesteam(String[] teamData)
 {
	sl.iSleep(6);
	driver.findElement(By.xpath(stp.salesteamname)).sendKeys(teamData[1]);
	WebElement tl = driver.findElement(By.xpath(stp.teamleader));
	tl.sendKeys(teamData[2]);
	tl.sendKeys(Keys.ARROW_DOWN);
	tl.sendKeys(Keys.ENTER);
	sl.iSleep(6);
    driver.findElement(By.xpath(stp.emailalias)).sendKeys(teamData[3]);
    WebElement assign = driver.findElement(By.xpath(stp.assignto));
    assign.sendKeys(teamData[4]);
    assign.sendKeys(Keys.ARROW_DOWN);
    assign.sendKeys(Keys.ENTER);
    driver.findElement(By.xpath(stp.add)).click();
    sl.iSleep(5);
    driver.findElement(By.xpath(stp.addmembercreate)).click();
    sl.iSleep(5);
    driver.findElement(By.xpath(stp.teammembname)).sendKeys(teamData[5]);
    sl.iSleep(3);
    driver.findElement(By.xpath(stp.teammail)).sendKeys(teamData[6]);
    sl.iSleep(3);
    driver.findElement(By.xpath(stp.teammammobile)).sendKeys(teamData[7]);
    sl.iSleep(5);
    driver.findElement(By.xpath(stp.saveandclose)).click();
    sl.iSleep(8);
    driver.findElement(By.xpath(stp.finalsave)).click();
    
    
 }
 public void salesteamrandom() throws EncryptedDocumentException, IOException
 {
	   ExcelUtilities ed=new ExcelUtilities();
	   ed.readandwrit("Sheet1", 5, 2, 3);
	   ed.readandwrit("Sheet1", 5, 5, 6);
 }
}
