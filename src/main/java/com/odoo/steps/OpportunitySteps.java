package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.pageobjects.LoginPage;
import com.odoo.pageobjects.OpportuPipelinePage;

public class OpportunitySteps {
	WebDriver driver;
	LoginPage lp;
   OpportuPipelinePage opp;
   
public OpportunitySteps(WebDriver driver){
	
	this.driver=driver;
	lp=new LoginPage();
	
	opp= new OpportuPipelinePage();
	
	}
public void CreatePiplineBtn(){
	driver.findElement(By.xpath(opp.createPipeBtn)).click();
	
	}
public void EnterOpportunity(String oppName){
	driver.findElement(By.xpath(opp.opportuBtn)).sendKeys(oppName);;
	}

//need select class code

  public void EnterCustomerName(String custName){
	WebElement custDrpDwn = driver.findElement(By.xpath(opp.selectCustBtn));
	custDrpDwn.sendKeys(custName,(Keys.ENTER));
	
	
}
public void EnterExpectedRevenue(String revenue){
	driver.findElement(By.xpath(opp.expectedRevenue)).sendKeys(revenue);
	
	
}	

public void AddBtn(){
	
	driver.findElement(By.xpath(opp.addBtn)).click();
	
}
	
}
