package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SalesTeamPage;

public class SalesTeamSteps
{
WebDriver driver;
SalesTeamPage stp;
SeleniumLib sl;

public SalesTeamSteps(WebDriver driver)
{
	this.driver=driver;
	stp=new SalesTeamPage();
	sl=new SeleniumLib(driver);
}
public void createSalesTeam(String salesnmae,String [] salesData)
{
	sl.iSleep(5);
	driver.findElement(By.xpath(stp.salesName)).sendKeys(salesnmae);
	driver.findElement(By.xpath(stp.teamLeader)).sendKeys(salesData[4]+Keys.ENTER);
	driver.findElement(By.xpath(stp.emailAlias)).sendKeys(salesData[5]);
//	WebElement alisdrpDwn = driver.findElement(By.xpath(stp.aliasContactDrpDwn));
//	sl.selectDrpDwnOption(alisdrpDwn, 1);
	sl.iSleep(5);
	driver.findElement(By.xpath(stp.assignTo)).sendKeys(salesData[6]+Keys.ENTER);
	
}




}
